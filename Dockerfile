FROM openjdk:21-ea-1-slim

MAINTAINER test user
COPY target/pasteBox-0.0.1-SNAPSHOT.jar pastebox.jar
ENTRYPOINT ["java", "-jar", "/pastebox.jar"]