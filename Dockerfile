FROM maven as builder
COPY . /src
WORKDIR /src
RUN mvn package && ls -lah /src/target

FROM segator/pgstosrt as runtime
WORKDIR /app
COPY --from=builder /src/target/mkvroomba.jar /app/mkvroomba.jar
COPY entrypoint.sh /entrypoint.sh
RUN apt-get update && apt-get install openjdk8 && chmod +x /entrypoint.sh 
ENTRYPOINT /entrypoint.sh
CMD -help
