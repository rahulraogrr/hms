FROM openjdk:11
ADD target/hms-0.0.1-SNAPSHOT.jar hms-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hms-0.0.1-SNAPSHOT.jar"]