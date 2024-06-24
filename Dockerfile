FROM --platform=linux/amd64 openjdk:17-jdk-slim-buster

WORKDIR /app
COPY pom.xml .
COPY src src/
COPY target/t-bot-1.0.8.jar /app/t-bot-1.0.8.jar
EXPOSE 8080

CMD ["java", "-jar", "t-bot-1.0.8.jar"]