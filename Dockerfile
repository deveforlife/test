FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} backend-fasep.jar

ENTRYPOINT ["java", "-jar", "backend-fasep.jar"]

EXPOSE 8080