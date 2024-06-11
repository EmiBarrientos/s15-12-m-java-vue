FROM amazoncorretto:17-alpine-jdk

ARG JAR_FILE=target/Propiedades360-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} propiedades360.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "propiedades360.jar"]