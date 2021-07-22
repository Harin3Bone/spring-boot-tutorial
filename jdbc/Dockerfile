FROM openjdk:11
VOLUME [ "/tmp" ]

ARG jar

COPY ${jar} app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]