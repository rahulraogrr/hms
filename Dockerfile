FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} hms.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/hms.jar"]