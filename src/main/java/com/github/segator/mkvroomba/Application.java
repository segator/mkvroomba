package com.github.segator.mkvroomba;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;
import org.apache.commons.io.output.NullOutputStream;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static String copyStrategy ="soft";
    public static String audiocodec ="aac";
    public static String audiobitrate ="480k";
    public static Process ffmpeg,mkvextract,pgssrt;
    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("help","print this message");
        options.addOption("force","override output file if exists");
        options.addOption("input", true, "MKV file to proceed");
        options.addOption("output", true, "MKV file output or directory");
        options.addOption("audiocodec", true, "ffmpeg audio codec, default "+audiocodec);
        options.addOption("audiobitrate", true, "ffmpeg audio bitrate, default"+audiobitrate);
        options.addOption("copystrategy", true, "If the file is already proceesed how we copy the file(copy,hard,soft)");
        options.addOption("dryrun", false, "do a test");

        HelpFormatter formatter = new HelpFormatter();

        CommandLineParser parser = new DefaultParser();
        File mkvInputFile,mkvOutputFile;
        boolean dryRun=false;
        boolean force=false;
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("input")) {
                mkvInputFile = new File(cmd.getOptionValue("input"));
                if(!mkvInputFile.exists()){
                    throw new Exception(mkvInputFile.toString() + " Does not exists");
                }
            } else {
                throw new Exception("-input is mandary");
            }
            if (cmd.hasOption("dryrun")) {
                dryRun=true;
            }
            if (cmd.hasOption("audiocodec")) {
                audiocodec = cmd.getOptionValue("audiocodec");
            }
            if (cmd.hasOption("audiobitrate")) {
                audiobitrate = cmd.getOptionValue("audiobitrate");
            }
            if (cmd.hasOption("force")) {
                force=true;
            }
            if (cmd.hasOption("copystrategy")) {
                copyStrategy = cmd.getOptionValue("copystrategy");
            }

            if (cmd.hasOption("output")) {
                mkvOutputFile = new File(cmd.getOptionValue("output"));
            } else {
                throw new Exception("-output is mandary");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            formatter.printHelp("help", options);
            System.exit(1);
            return;
        }


        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Gracefull shutdown....");
                if(ffmpeg!=null){
                    try {
                        ffmpeg.destroy();
                    }catch(Exception ex){
                    }
                    try {
                      mkvextract.destroy();
                    }catch(Exception ex){

                    }
                    try{
                        pgssrt.destroy();
                    }catch(Exception ex){

                    }
              }
          }
        });
        if(!processFolder(mkvInputFile,mkvOutputFile,dryRun,force)){
            System.exit(2);
            return;
        }

    }
    public static boolean processFolder(File inputFile,File outputFile,boolean dryRun,boolean force) throws Exception {
        boolean task=true;
        if(inputFile.isFile()){
            try {
                return processFile(inputFile, outputFile, dryRun, force);
            }catch(Exception ex){
                System.out.println("[ERROR]"+ex);
                task= false;
            }
        }else{

            for (File file : inputFile.listFiles()) {
                File destinationFile = Paths.get(outputFile.toString(),file.getName()).toFile();
                if(file.isDirectory()){
                    destinationFile.mkdirs();
                }
                if(!processFolder(file,destinationFile,dryRun,force)){
                    task=false;
                }
            }
        }
        return task;
    }

    public static boolean processFile(File mkvInputFile, File mkvOutputFile,boolean dryRun,boolean force) throws Exception {
        if(!mkvInputFile.getName().toLowerCase().endsWith(".mkv")){
            return true;
        }else{

            System.out.println("\r\n######### " + mkvInputFile.getName() + "############");
        }
        System.out.println("[PATH] "+mkvInputFile.getParent());
        StringBuilder filesToAdd=new StringBuilder(" -i \""+mkvInputFile.toString()+ "\" ");
        StringBuilder mapsFiles = new StringBuilder("-map_metadata 0 ");
        StringBuilder mkvExtractCommand = new StringBuilder("mkvextract tracks \"").append(mkvInputFile.toString()).append("\" ");
        StringBuilder ffmpegCommand = new StringBuilder("ffmpeg  -hide_banner {input_files} {map_files} ");
        ObjectMapper mapper = new ObjectMapper();
        String[] ffprobe = {"ffprobe","-v","quiet","-print_format","json","-show_format","-show_streams",mkvInputFile.toString()};
        Process ffprobeProc = Runtime.getRuntime().exec(ffprobe);
        MediaInfo mediaInfo = mapper.readValue(ffprobeProc.getInputStream(), MediaInfo.class);
        if (ffprobeProc.exitValue()!=0){
            throw new Exception("Invalid exit value from ffprobe " + ffprobeProc.exitValue());
        }
        List<String> codecPrio = Arrays.asList("truehd","dts","ac-3","ac3","aac","mp3");
        List<String> requireConvert = Arrays.asList("truehd","dts","eac3");
        List<Stream> subtitleStream = mediaInfo.getStreams().stream().filter(stream -> stream.getCodecType().equals("subtitle") ).collect(Collectors.toList());
        List<Stream> videoStreams = mediaInfo.getStreams().stream().filter(stream -> stream.getCodecType().equals("video") ).collect(Collectors.toList());
        List<Stream> audioStreams = mediaInfo.getStreams().stream().filter(stream -> stream.getCodecType().equals("audio")).collect(Collectors.toList());
        List<Stream> otherStreams = mediaInfo.getStreams().stream().filter(stream -> !stream.getCodecType().equals("audio") &&
                !stream.getCodecType().equals("subtitle") && !stream.getCodecType().equals("video")  ).collect(Collectors.toList());
        Map<String,List<Stream>> audioStreamByLanguage  = audioStreams.stream().collect(Collectors.groupingBy( stream  -> stream.getTags().getLanguage()!=null?stream.getTags().getLanguage():"none"));
        List<Stream>  acceptStream = new ArrayList();
        audioStreamByLanguage.forEach( (key,value) -> {
            Stream streamByLanguage =value.stream().sorted((Stream c1, Stream c2 ) -> {
                return Integer.valueOf(codecPrio.indexOf(c1.getCodecName().toLowerCase())).compareTo(codecPrio.indexOf(c2.getCodecName().toLowerCase()));
            }).findFirst().get();
            acceptStream.add(streamByLanguage);
        });
        List<Stream> subsToEncode=new ArrayList();
        int subtiIndex= 0;


        boolean requireTransmux = false;
        for(Stream stream: videoStreams){
            // System.out.println(stream.getCodecType());
            System.out.println("[VIDEO] codec:"+stream.getCodecName());
            ffmpegCommand.append(" -map 0:").append(stream.getIndex());
        }
        int accepted = 0;
        for (Stream stream: audioStreams) {
            String layout;
            if(stream.getChannelLayout()!=null && !stream.getChannelLayout().isEmpty()){
                layout = stream.getChannelLayout();
            }else{
                layout = (stream.getChannels()-1) + ".1";
            }

            String audioString = "[AUDIO][codec:" + stream.getCodecName() + "|description:" + stream.getTags().getTitle()+
                    "|channel:"+layout + "|language:"+stream.getTags().getLanguage() + "]";

            if(acceptStream.contains(stream)){
                //String ffmpegAudioPositionMap = "a:"+ (stream.getIndex()-1);
                String ffmpegAudioPositionMap = "a:"+ accepted;
                accepted = accepted+1;
                ffmpegCommand.append(" -map 0:").append(stream.getIndex());

                stream.getTags().setTitle(audiocodec.toUpperCase() + " " + layout);
                ffmpegCommand.append(" -metadata:s:").append(ffmpegAudioPositionMap).append(" title=\"").append(stream.getTags().getTitle()).append("\" ");
                if(requireConvert.contains(stream.getCodecName().toLowerCase())){
                    requireTransmux=true;
                    System.out.println(audioString +" convert codec:"+audiocodec.toUpperCase()+"|description " +stream.getTags().getTitle());
                    ffmpegCommand.append(" -c:").append(ffmpegAudioPositionMap).append(" "+ audiocodec + " ").append(" -b:").append(ffmpegAudioPositionMap).append(" " + audiobitrate + " ");
                }else{
                    ffmpegCommand.append(" -c:").append(ffmpegAudioPositionMap).append(" copy");
                }
            }else{
                requireTransmux=true;
                System.out.println(audioString +" remove");
            }
        }

        for(Stream stream: subtitleStream){
            String subtString = "[SUBTITLE][codec:" + stream.getCodecName() + "|description:" + stream.getTags().getTitle()+
                    "|language:"+stream.getTags().getLanguage() + "]";
            // System.out.println(stream.getCodecType());
            if(stream.getCodecName().toLowerCase().equals("hdmv_pgs_subtitle")){
                requireTransmux=true;
                subsToEncode.add(stream);
                mkvExtractCommand.append(" ").append(stream.getIndex()).append(":").append(stream.getIndex()).append(".sup");
                System.out.println(subtString+"convert codec:srt");
            }else{
                subtiIndex= subtiIndex+1;
                ffmpegCommand.append(" -map 0:").append(stream.getIndex());
            }
        }
        int mapFiles = 1;
        for(Stream stream: subsToEncode){
            String outputFile = Paths.get(new File("").toString(),stream.getIndex()+".srt").toAbsolutePath().toString();
            filesToAdd.append(" -i \""+outputFile+ "\" ");
            mapsFiles.append(" -map ").append(mapFiles+":s");
            mapFiles=mapFiles+1;
            ffmpegCommand.append(" -metadata:s:s:").append(subtiIndex).append(" language=").append(stream.getTags().getLanguage());
            if(stream.getTags().getTitle()!=null){
                ffmpegCommand.append(" -metadata:s:s:").append(subtiIndex).append(" title=\""+stream.getTags().getTitle()+"\" ");
            }
            subtiIndex= subtiIndex+1;
        }


        for(Stream stream: otherStreams){
            // System.out.println(stream.getCodecType());
            ffmpegCommand.append(" -map 0:").append(stream.getIndex());
        }
        ffmpegCommand.append(" -sub_charenc UTF-8 -scodec copy  -vcodec copy ");

        ffmpegCommand.append(" \"").append(mkvOutputFile.toString()).append("\"");
        String ffmpegCommandString = ffmpegCommand.toString().replace("{input_files}",filesToAdd.toString()).replace("{map_files}",mapsFiles.toString());

        if(requireTransmux) {
            if(!dryRun) {
                if(mkvOutputFile.exists()){
                    if(force){
                        mkvOutputFile.delete();
                    }else{
                        throw new Exception("[ERROR] Already exists, add -force to overwrite the file");
                    }
                }
                if(subsToEncode.size()>0){
                    System.out.println("[EXEC]"+ mkvExtractCommand);
                    mkvextract = Runtime.getRuntime().exec(translateCommandline(mkvExtractCommand.toString()));
                    try {
                        inheritIO(mkvextract.getInputStream(),new PrintStream(new NullOutputStream()),"");
                        inheritIO(mkvextract.getErrorStream(),new PrintStream(new NullOutputStream()),"");
                        mkvextract.waitFor();
                    } catch(Exception ex) {
                        ex.printStackTrace();
                        return false;
                    }
                    List<Thread> subsEncodeThreads = new ArrayList();
                    for (Stream stream: subsToEncode ) {
                        Thread t = new Thread(new Runnable() {
                            public void run() {
                                File subFile = Paths.get(new File("").toString(),stream.getIndex()+".srt").toFile();
                                String sourceFile = Paths.get(new File("").toString(),stream.getIndex()+".sup").toAbsolutePath().toString();
                                String outputFile = Paths.get(new File("").toString(),stream.getIndex()+".srt").toAbsolutePath().toString();
                                String pgstosrt = "dotnet PgsToSrt.dll --input \"" + sourceFile + "\" --output \""
                                        +outputFile+"\" --tesseractlanguage "+langConverter(stream.getTags().getLanguage());
                                System.out.println("[EXEC]"+ pgstosrt);
                                try{
                                    pgssrt = Runtime.getRuntime().exec(translateCommandline(pgstosrt));
                                    inheritIO(pgssrt.getInputStream(),System.err,"[pgstosrt]["+stream.getIndex()+"]");
                                    inheritIO(pgssrt.getErrorStream(),new PrintStream(new NullOutputStream()),"");
                                    pgssrt.waitFor();
                                    if(!subFile.exists()){
                                        throw new Exception("Something wrong in the sub to srt convertion for "+ stream.getIndex() + " "+stream.getTags().getLanguage());
                                    }
                                } catch(Exception ex) {
                                    ex.printStackTrace();

                                }
                            }
                        });
                        t.start();
                        subsEncodeThreads.add(t);
                    }
                    for (Thread t:  subsEncodeThreads) {
                        t.join();
                    }
                }


                System.out.println("[EXEC] "+ffmpegCommandString);
                ffmpeg = Runtime.getRuntime().exec(translateCommandline(ffmpegCommandString));
                try {
                    inheritIO(ffmpeg.getInputStream(),System.err,"");
                    inheritIO(ffmpeg.getErrorStream(),System.err,"");
                    ffmpeg.waitFor();
                } catch(Exception ex) {
                    ex.printStackTrace();
                    mkvOutputFile.delete();
                }
            }else{
                System.out.println("[DRY-RUN] " +ffmpegCommandString);
            }
        }else{
            if(!dryRun) {
            System.out.println("[COPY] No changes needed: " + copyStrategy);
                //tod@ copy file or hardlink
                switch (copyStrategy) {
                    case "soft":
                        Files.createSymbolicLink(mkvOutputFile.toPath(), mkvInputFile.toPath());
                        break;
                    case "hard":
                        Files.createLink(mkvOutputFile.toPath(), mkvInputFile.toPath());
                        break;
                    case "copy":
                        Files.copy(mkvInputFile.toPath(), mkvOutputFile.toPath());
                        break;
                    default:
                        throw new Exception("Invalid copyStrategy " + copyStrategy);
                }
                System.out.println("[INFO]  Nothing to do");
                return true;
            }else{
                System.out.println("[DRY-RUN] copy stategy: " +copyStrategy );
            }
        }
        return true;
    }

    private static String langConverter(String language) {
        Map<String,List<String>> relation = new HashMap();
        relation.put("deu",Arrays.asList("ger","ge","de"));
        relation.put("eng",Arrays.asList("en","uk"));
        relation.put("spa",Arrays.asList("es"));
        relation.put("fra",Arrays.asList("fre"));
        relation.put("chi_tra",Arrays.asList("chi"));

        for (Map.Entry<String,List<String>>  entry: relation.entrySet()) {
            if(entry.getValue().contains(language.toLowerCase())){
                return entry.getKey();
            }
        }
        return language;
    }

    private static void inheritIO(final InputStream src, final PrintStream dest,String prefix) {
        new Thread(new Runnable() {
            public void run() {
                Scanner sc = new Scanner(src);
                while (sc.hasNextLine()) {
                    dest.println(prefix + sc.nextLine());
                }
            }
        }).start();
    }
    //ffmpeg -i "The.Lion.King.2019.MULTi.2160p.UHD.BluRay.REMUX.HDR.HEVC.TrueHD.Atmos.7.1-TOXIC.mkv" -map 0  -map_metadata 0
    // -vcodec copy -scodec copy -c:a copy  -c:a:0 ac3 -b:a:0 640k  -metadata:s:a:0 title="patata" -t 60 output.mkv"
    public static String[] translateCommandline(String toProcess) {
        if (toProcess == null || toProcess.length() == 0) {
            //no command? no string
            return new String[0];
        }
        // parse with a simple finite state machine

        final int normal = 0;
        final int inQuote = 1;
        final int inDoubleQuote = 2;
        int state = normal;
        final StringTokenizer tok = new StringTokenizer(toProcess, "\"\' ", true);
        final ArrayList<String> result = new ArrayList<String>();
        final StringBuilder current = new StringBuilder();
        boolean lastTokenHasBeenQuoted = false;

        while (tok.hasMoreTokens()) {
            String nextTok = tok.nextToken();
            switch (state) {
                case inQuote:
                    if ("\'".equals(nextTok)) {
                        lastTokenHasBeenQuoted = true;
                        state = normal;
                    } else {
                        current.append(nextTok);
                    }
                    break;
                case inDoubleQuote:
                    if ("\"".equals(nextTok)) {
                        lastTokenHasBeenQuoted = true;
                        state = normal;
                    } else {
                        current.append(nextTok);
                    }
                    break;
                default:
                    if ("\'".equals(nextTok)) {
                        state = inQuote;
                    } else if ("\"".equals(nextTok)) {
                        state = inDoubleQuote;
                    } else if (" ".equals(nextTok)) {
                        if (lastTokenHasBeenQuoted || current.length() != 0) {
                            result.add(current.toString());
                            current.setLength(0);
                        }
                    } else {
                        current.append(nextTok);
                    }
                    lastTokenHasBeenQuoted = false;
                    break;
            }
        }
        if (lastTokenHasBeenQuoted || current.length() != 0) {
            result.add(current.toString());
        }
        if (state == inQuote || state == inDoubleQuote) {
            throw new RuntimeException("unbalanced quotes in " + toProcess);
        }
        return result.toArray(new String[result.size()]);
    }
}
