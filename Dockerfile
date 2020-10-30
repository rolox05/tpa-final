FROM openjdk:14-alpine
COPY target/micronautPersonaApp-*.jar micronautPersonaApp.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronautPersonaApp.jar"]