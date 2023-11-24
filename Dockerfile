# Tienes que tener buildeado el proyecto usar [mvn clean install -DskipTests]
FROM openjdk:17-alpine
LABEL authors="ecortez"

COPY target/core-service-*.jar /app.jar

RUN mkdir /conf

ENTRYPOINT exec java -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=/conf/application.yml