FROM openjdk:21-jdk

ENV JAR_NAME example-voting-app-*.jar

COPY build/libs/$JAR_NAME $JAR_NAME

EXPOSE 8080

ENTRYPOINT java -jar $JAR_NAME