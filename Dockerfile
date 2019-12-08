FROM maven as builder
COPY . /src
WORKDIR /src
RUN mvn package && ls -lah /src/target

FROM jrottenberg/ffmpeg:4.1-scratch as ffmpeg

FROM segator/pgstosrt as runtime
WORKDIR /app
COPY --from=builder /src/target/mkvroomba.jar /app/mkvroomba.jar
COPY --from=ffmpeg /bin/ /bin/
COPY --from=ffmpeg /lib/ /lib/

COPY entrypoint.sh /entrypoint.sh
RUN apt-get update && apt-get install mkvtoolnix  openjdk-8-jre -y && chmod +x /entrypoint.sh 
ENTRYPOINT /entrypoint.sh
CMD -help
