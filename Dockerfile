FROM openjdk:17

COPY target/"bach-microservice-spring-boot-0.0.1-SNAPSHOT-shaded.pom" app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]