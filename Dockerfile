FROM eclipse-temurin:17

LABEL author=codifacil.club

COPY target/demo-backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]