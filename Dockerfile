FROM openjdk:17-jdk-slim

WORKDIR /app
COPY pom.xml .
COPY src src/
COPY target/t-bot-1.0-SNAPSHOT.jar /app/t-bot-1.0-SNAPSHOT.jar
EXPOSE 8080

CMD ["java", "-jar", "t-bot-1.0-SNAPSHOT.jar"]