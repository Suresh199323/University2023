FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/university.jar university.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "university.jar"]