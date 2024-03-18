# Spring recommends BellSoft Liberica JDK version 17. https://spring.io/quickstart/
# https://registry.hub.docker.com/u/bellsoft
#FROM bellsoft/liberica-openjdk-alpine:21

# ..however github actions also support amazon corretto (see .github/workflows/build)
FROM amazoncorretto:21-alpine

LABEL authors="anlcan"

# Install newrelic agent
RUN wget https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip \
  && unzip newrelic-java.zip -d /usr/local/

# DO NOT RUN healtcheks on the image, let the pod die
# HEALTHCHECK --interval=30s --timeout=3s --retries=1 CMD wget -qO- http://localhost:8080/actuator/health/ | grep UP || exit 1

# run `mvn clean verify` first
COPY target/boilerplate-0.1.jar app.jar

# better to run this with a java user?
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS \
                          -javaagent:/usr/local/newrelic/newrelic.jar \
                          -jar app.jar"]

