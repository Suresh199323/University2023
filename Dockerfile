FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY University2023/target/prep-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "prep-0.0.1-SNAPSHOT.jar"]