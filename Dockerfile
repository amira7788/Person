FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
# To reduce Tomcat startup time
ENTRYPOINT ["java", "-jar","/app.jar"]

