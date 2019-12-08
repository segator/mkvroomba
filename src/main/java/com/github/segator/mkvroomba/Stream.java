
package com.github.segator.mkvroomba;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "index",
    "codec_name",
    "codec_long_name",
    "profile",
    "codec_type",
    "codec_time_base",
    "codec_tag_string",
    "codec_tag",
    "width",
    "height",
    "coded_width",
    "coded_height",
    "has_b_frames",
    "sample_aspect_ratio",
    "display_aspect_ratio",
    "pix_fmt",
    "level",
    "color_range",
    "color_space",
    "color_transfer",
    "color_primaries",
    "refs",
    "r_frame_rate",
    "avg_frame_rate",
    "time_base",
    "start_pts",
    "start_time",
    "disposition",
    "tags",
    "sample_fmt",
    "sample_rate",
    "channels",
    "channel_layout",
    "bits_per_sample",
    "bits_per_raw_sample",
    "dmix_mode",
    "ltrt_cmixlev",
    "ltrt_surmixlev",
    "loro_cmixlev",
    "loro_surmixlev",
    "bit_rate",
    "duration_ts",
    "duration"
})
public class Stream implements Serializable
{

    @JsonProperty("index")
    private Integer index;
    @JsonProperty("codec_name")
    private String codecName;
    @JsonProperty("codec_long_name")
    private String codecLongName;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("codec_type")
    private String codecType;
    @JsonProperty("codec_time_base")
    private String codecTimeBase;
    @JsonProperty("codec_tag_string")
    private String codecTagString;
    @JsonProperty("codec_tag")
    private String codecTag;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("coded_width")
    private Integer codedWidth;
    @JsonProperty("coded_height")
    private Integer codedHeight;
    @JsonProperty("has_b_frames")
    private Integer hasBFrames;
    @JsonProperty("sample_aspect_ratio")
    private String sampleAspectRatio;
    @JsonProperty("display_aspect_ratio")
    private String displayAspectRatio;
    @JsonProperty("pix_fmt")
    private String pixFmt;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("color_range")
    private String colorRange;
    @JsonProperty("color_space")
    private String colorSpace;
    @JsonProperty("color_transfer")
    private String colorTransfer;
    @JsonProperty("color_primaries")
    private String colorPrimaries;
    @JsonProperty("refs")
    private Integer refs;
    @JsonProperty("r_frame_rate")
    private String rFrameRate;
    @JsonProperty("avg_frame_rate")
    private String avgFrameRate;
    @JsonProperty("time_base")
    private String timeBase;
    @JsonProperty("start_pts")
    private Integer startPts;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("disposition")
    private Disposition disposition;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("sample_fmt")
    private String sampleFmt;
    @JsonProperty("sample_rate")
    private String sampleRate;
    @JsonProperty("channels")
    private Integer channels;
    @JsonProperty("channel_layout")
    private String channelLayout;
    @JsonProperty("bits_per_sample")
    private Integer bitsPerSample;
    @JsonProperty("bits_per_raw_sample")
    private String bitsPerRawSample;
    @JsonProperty("dmix_mode")
    private String dmixMode;
    @JsonProperty("ltrt_cmixlev")
    private String ltrtCmixlev;
    @JsonProperty("ltrt_surmixlev")
    private String ltrtSurmixlev;
    @JsonProperty("loro_cmixlev")
    private String loroCmixlev;
    @JsonProperty("loro_surmixlev")
    private String loroSurmixlev;
    @JsonProperty("bit_rate")
    private String bitRate;
    @JsonProperty("duration_ts")
    private Integer durationTs;
    @JsonProperty("duration")
    private String duration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8968133376025637327L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stream() {
    }

    /**
     * 
     * @param hasBFrames
     * @param colorRange
     * @param codecTimeBase
     * @param codecType
     * @param avgFrameRate
     * @param colorSpace
     * @param duration
     * @param startPts
     * @param bitsPerSample
     * @param codedWidth
     * @param dmixMode
     * @param durationTs
     * @param sampleFmt
     * @param bitRate
     * @param startTime
     * @param timeBase
     * @param colorTransfer
     * @param height
     * @param sampleAspectRatio
     * @param channelLayout
     * @param ltrtSurmixlev
     * @param level
     * @param profile
     * @param codecTagString
     * @param index
     * @param bitsPerRawSample
     * @param loroSurmixlev
     * @param sampleRate
     * @param codecTag
     * @param displayAspectRatio
     * @param tags
     * @param pixFmt
     * @param disposition
     * @param channels
     * @param loroCmixlev
     * @param refs
     * @param codecLongName
     * @param width
     * @param rFrameRate
     * @param codedHeight
     * @param colorPrimaries
     * @param codecName
     * @param ltrtCmixlev
     */
    public Stream(Integer index, String codecName, String codecLongName, String profile, String codecType, String codecTimeBase, String codecTagString, String codecTag, Integer width, Integer height, Integer codedWidth, Integer codedHeight, Integer hasBFrames, String sampleAspectRatio, String displayAspectRatio, String pixFmt, Integer level, String colorRange, String colorSpace, String colorTransfer, String colorPrimaries, Integer refs, String rFrameRate, String avgFrameRate, String timeBase, Integer startPts, String startTime, Disposition disposition, Tags tags, String sampleFmt, String sampleRate, Integer channels, String channelLayout, Integer bitsPerSample, String bitsPerRawSample, String dmixMode, String ltrtCmixlev, String ltrtSurmixlev, String loroCmixlev, String loroSurmixlev, String bitRate, Integer durationTs, String duration) {
        super();
        this.index = index;
        this.codecName = codecName;
        this.codecLongName = codecLongName;
        this.profile = profile;
        this.codecType = codecType;
        this.codecTimeBase = codecTimeBase;
        this.codecTagString = codecTagString;
        this.codecTag = codecTag;
        this.width = width;
        this.height = height;
        this.codedWidth = codedWidth;
        this.codedHeight = codedHeight;
        this.hasBFrames = hasBFrames;
        this.sampleAspectRatio = sampleAspectRatio;
        this.displayAspectRatio = displayAspectRatio;
        this.pixFmt = pixFmt;
        this.level = level;
        this.colorRange = colorRange;
        this.colorSpace = colorSpace;
        this.colorTransfer = colorTransfer;
        this.colorPrimaries = colorPrimaries;
        this.refs = refs;
        this.rFrameRate = rFrameRate;
        this.avgFrameRate = avgFrameRate;
        this.timeBase = timeBase;
        this.startPts = startPts;
        this.startTime = startTime;
        this.disposition = disposition;
        this.tags = tags;
        this.sampleFmt = sampleFmt;
        this.sampleRate = sampleRate;
        this.channels = channels;
        this.channelLayout = channelLayout;
        this.bitsPerSample = bitsPerSample;
        this.bitsPerRawSample = bitsPerRawSample;
        this.dmixMode = dmixMode;
        this.ltrtCmixlev = ltrtCmixlev;
        this.ltrtSurmixlev = ltrtSurmixlev;
        this.loroCmixlev = loroCmixlev;
        this.loroSurmixlev = loroSurmixlev;
        this.bitRate = bitRate;
        this.durationTs = durationTs;
        this.duration = duration;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("codec_name")
    public String getCodecName() {
        return codecName;
    }

    @JsonProperty("codec_name")
    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    @JsonProperty("codec_long_name")
    public String getCodecLongName() {
        return codecLongName;
    }

    @JsonProperty("codec_long_name")
    public void setCodecLongName(String codecLongName) {
        this.codecLongName = codecLongName;
    }

    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonProperty("codec_type")
    public String getCodecType() {
        return codecType;
    }

    @JsonProperty("codec_type")
    public void setCodecType(String codecType) {
        this.codecType = codecType;
    }

    @JsonProperty("codec_time_base")
    public String getCodecTimeBase() {
        return codecTimeBase;
    }

    @JsonProperty("codec_time_base")
    public void setCodecTimeBase(String codecTimeBase) {
        this.codecTimeBase = codecTimeBase;
    }

    @JsonProperty("codec_tag_string")
    public String getCodecTagString() {
        return codecTagString;
    }

    @JsonProperty("codec_tag_string")
    public void setCodecTagString(String codecTagString) {
        this.codecTagString = codecTagString;
    }

    @JsonProperty("codec_tag")
    public String getCodecTag() {
        return codecTag;
    }

    @JsonProperty("codec_tag")
    public void setCodecTag(String codecTag) {
        this.codecTag = codecTag;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("coded_width")
    public Integer getCodedWidth() {
        return codedWidth;
    }

    @JsonProperty("coded_width")
    public void setCodedWidth(Integer codedWidth) {
        this.codedWidth = codedWidth;
    }

    @JsonProperty("coded_height")
    public Integer getCodedHeight() {
        return codedHeight;
    }

    @JsonProperty("coded_height")
    public void setCodedHeight(Integer codedHeight) {
        this.codedHeight = codedHeight;
    }

    @JsonProperty("has_b_frames")
    public Integer getHasBFrames() {
        return hasBFrames;
    }

    @JsonProperty("has_b_frames")
    public void setHasBFrames(Integer hasBFrames) {
        this.hasBFrames = hasBFrames;
    }

    @JsonProperty("sample_aspect_ratio")
    public String getSampleAspectRatio() {
        return sampleAspectRatio;
    }

    @JsonProperty("sample_aspect_ratio")
    public void setSampleAspectRatio(String sampleAspectRatio) {
        this.sampleAspectRatio = sampleAspectRatio;
    }

    @JsonProperty("display_aspect_ratio")
    public String getDisplayAspectRatio() {
        return displayAspectRatio;
    }

    @JsonProperty("display_aspect_ratio")
    public void setDisplayAspectRatio(String displayAspectRatio) {
        this.displayAspectRatio = displayAspectRatio;
    }

    @JsonProperty("pix_fmt")
    public String getPixFmt() {
        return pixFmt;
    }

    @JsonProperty("pix_fmt")
    public void setPixFmt(String pixFmt) {
        this.pixFmt = pixFmt;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("color_range")
    public String getColorRange() {
        return colorRange;
    }

    @JsonProperty("color_range")
    public void setColorRange(String colorRange) {
        this.colorRange = colorRange;
    }

    @JsonProperty("color_space")
    public String getColorSpace() {
        return colorSpace;
    }

    @JsonProperty("color_space")
    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    @JsonProperty("color_transfer")
    public String getColorTransfer() {
        return colorTransfer;
    }

    @JsonProperty("color_transfer")
    public void setColorTransfer(String colorTransfer) {
        this.colorTransfer = colorTransfer;
    }

    @JsonProperty("color_primaries")
    public String getColorPrimaries() {
        return colorPrimaries;
    }

    @JsonProperty("color_primaries")
    public void setColorPrimaries(String colorPrimaries) {
        this.colorPrimaries = colorPrimaries;
    }

    @JsonProperty("refs")
    public Integer getRefs() {
        return refs;
    }

    @JsonProperty("refs")
    public void setRefs(Integer refs) {
        this.refs = refs;
    }

    @JsonProperty("r_frame_rate")
    public String getRFrameRate() {
        return rFrameRate;
    }

    @JsonProperty("r_frame_rate")
    public void setRFrameRate(String rFrameRate) {
        this.rFrameRate = rFrameRate;
    }

    @JsonProperty("avg_frame_rate")
    public String getAvgFrameRate() {
        return avgFrameRate;
    }

    @JsonProperty("avg_frame_rate")
    public void setAvgFrameRate(String avgFrameRate) {
        this.avgFrameRate = avgFrameRate;
    }

    @JsonProperty("time_base")
    public String getTimeBase() {
        return timeBase;
    }

    @JsonProperty("time_base")
    public void setTimeBase(String timeBase) {
        this.timeBase = timeBase;
    }

    @JsonProperty("start_pts")
    public Integer getStartPts() {
        return startPts;
    }

    @JsonProperty("start_pts")
    public void setStartPts(Integer startPts) {
        this.startPts = startPts;
    }

    @JsonProperty("start_time")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("disposition")
    public Disposition getDisposition() {
        return disposition;
    }

    @JsonProperty("disposition")
    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @JsonProperty("sample_fmt")
    public String getSampleFmt() {
        return sampleFmt;
    }

    @JsonProperty("sample_fmt")
    public void setSampleFmt(String sampleFmt) {
        this.sampleFmt = sampleFmt;
    }

    @JsonProperty("sample_rate")
    public String getSampleRate() {
        return sampleRate;
    }

    @JsonProperty("sample_rate")
    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    @JsonProperty("channels")
    public Integer getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    @JsonProperty("channel_layout")
    public String getChannelLayout() {
        return channelLayout;
    }

    @JsonProperty("channel_layout")
    public void setChannelLayout(String channelLayout) {
        this.channelLayout = channelLayout;
    }

    @JsonProperty("bits_per_sample")
    public Integer getBitsPerSample() {
        return bitsPerSample;
    }

    @JsonProperty("bits_per_sample")
    public void setBitsPerSample(Integer bitsPerSample) {
        this.bitsPerSample = bitsPerSample;
    }

    @JsonProperty("bits_per_raw_sample")
    public String getBitsPerRawSample() {
        return bitsPerRawSample;
    }

    @JsonProperty("bits_per_raw_sample")
    public void setBitsPerRawSample(String bitsPerRawSample) {
        this.bitsPerRawSample = bitsPerRawSample;
    }

    @JsonProperty("dmix_mode")
    public String getDmixMode() {
        return dmixMode;
    }

    @JsonProperty("dmix_mode")
    public void setDmixMode(String dmixMode) {
        this.dmixMode = dmixMode;
    }

    @JsonProperty("ltrt_cmixlev")
    public String getLtrtCmixlev() {
        return ltrtCmixlev;
    }

    @JsonProperty("ltrt_cmixlev")
    public void setLtrtCmixlev(String ltrtCmixlev) {
        this.ltrtCmixlev = ltrtCmixlev;
    }

    @JsonProperty("ltrt_surmixlev")
    public String getLtrtSurmixlev() {
        return ltrtSurmixlev;
    }

    @JsonProperty("ltrt_surmixlev")
    public void setLtrtSurmixlev(String ltrtSurmixlev) {
        this.ltrtSurmixlev = ltrtSurmixlev;
    }

    @JsonProperty("loro_cmixlev")
    public String getLoroCmixlev() {
        return loroCmixlev;
    }

    @JsonProperty("loro_cmixlev")
    public void setLoroCmixlev(String loroCmixlev) {
        this.loroCmixlev = loroCmixlev;
    }

    @JsonProperty("loro_surmixlev")
    public String getLoroSurmixlev() {
        return loroSurmixlev;
    }

    @JsonProperty("loro_surmixlev")
    public void setLoroSurmixlev(String loroSurmixlev) {
        this.loroSurmixlev = loroSurmixlev;
    }

    @JsonProperty("bit_rate")
    public String getBitRate() {
        return bitRate;
    }

    @JsonProperty("bit_rate")
    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    @JsonProperty("duration_ts")
    public Integer getDurationTs() {
        return durationTs;
    }

    @JsonProperty("duration_ts")
    public void setDurationTs(Integer durationTs) {
        this.durationTs = durationTs;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("index", index).append("codecName", codecName).append("codecLongName", codecLongName).append("profile", profile).append("codecType", codecType).append("codecTimeBase", codecTimeBase).append("codecTagString", codecTagString).append("codecTag", codecTag).append("width", width).append("height", height).append("codedWidth", codedWidth).append("codedHeight", codedHeight).append("hasBFrames", hasBFrames).append("sampleAspectRatio", sampleAspectRatio).append("displayAspectRatio", displayAspectRatio).append("pixFmt", pixFmt).append("level", level).append("colorRange", colorRange).append("colorSpace", colorSpace).append("colorTransfer", colorTransfer).append("colorPrimaries", colorPrimaries).append("refs", refs).append("rFrameRate", rFrameRate).append("avgFrameRate", avgFrameRate).append("timeBase", timeBase).append("startPts", startPts).append("startTime", startTime).append("disposition", disposition).append("tags", tags).append("sampleFmt", sampleFmt).append("sampleRate", sampleRate).append("channels", channels).append("channelLayout", channelLayout).append("bitsPerSample", bitsPerSample).append("bitsPerRawSample", bitsPerRawSample).append("dmixMode", dmixMode).append("ltrtCmixlev", ltrtCmixlev).append("ltrtSurmixlev", ltrtSurmixlev).append("loroCmixlev", loroCmixlev).append("loroSurmixlev", loroSurmixlev).append("bitRate", bitRate).append("durationTs", durationTs).append("duration", duration).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hasBFrames).append(colorRange).append(codecTimeBase).append(codecType).append(avgFrameRate).append(colorSpace).append(duration).append(startPts).append(bitsPerSample).append(codedWidth).append(dmixMode).append(durationTs).append(sampleFmt).append(bitRate).append(startTime).append(timeBase).append(colorTransfer).append(height).append(sampleAspectRatio).append(channelLayout).append(ltrtSurmixlev).append(level).append(profile).append(codecTagString).append(index).append(bitsPerRawSample).append(loroSurmixlev).append(sampleRate).append(codecTag).append(displayAspectRatio).append(tags).append(pixFmt).append(disposition).append(channels).append(loroCmixlev).append(refs).append(codecLongName).append(width).append(rFrameRate).append(codedHeight).append(colorPrimaries).append(codecName).append(additionalProperties).append(ltrtCmixlev).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stream) == false) {
            return false;
        }
        Stream rhs = ((Stream) other);
        return new EqualsBuilder().append(hasBFrames, rhs.hasBFrames).append(colorRange, rhs.colorRange).append(codecTimeBase, rhs.codecTimeBase).append(codecType, rhs.codecType).append(avgFrameRate, rhs.avgFrameRate).append(colorSpace, rhs.colorSpace).append(duration, rhs.duration).append(startPts, rhs.startPts).append(bitsPerSample, rhs.bitsPerSample).append(codedWidth, rhs.codedWidth).append(dmixMode, rhs.dmixMode).append(durationTs, rhs.durationTs).append(sampleFmt, rhs.sampleFmt).append(bitRate, rhs.bitRate).append(startTime, rhs.startTime).append(timeBase, rhs.timeBase).append(colorTransfer, rhs.colorTransfer).append(height, rhs.height).append(sampleAspectRatio, rhs.sampleAspectRatio).append(channelLayout, rhs.channelLayout).append(ltrtSurmixlev, rhs.ltrtSurmixlev).append(level, rhs.level).append(profile, rhs.profile).append(codecTagString, rhs.codecTagString).append(index, rhs.index).append(bitsPerRawSample, rhs.bitsPerRawSample).append(loroSurmixlev, rhs.loroSurmixlev).append(sampleRate, rhs.sampleRate).append(codecTag, rhs.codecTag).append(displayAspectRatio, rhs.displayAspectRatio).append(tags, rhs.tags).append(pixFmt, rhs.pixFmt).append(disposition, rhs.disposition).append(channels, rhs.channels).append(loroCmixlev, rhs.loroCmixlev).append(refs, rhs.refs).append(codecLongName, rhs.codecLongName).append(width, rhs.width).append(rFrameRate, rhs.rFrameRate).append(codedHeight, rhs.codedHeight).append(colorPrimaries, rhs.colorPrimaries).append(codecName, rhs.codecName).append(additionalProperties, rhs.additionalProperties).append(ltrtCmixlev, rhs.ltrtCmixlev).isEquals();
    }

}
