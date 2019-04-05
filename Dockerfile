FROM gradle:jdk11-slim AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre-slim

EXPOSE 8080
COPY --from=build /home/gradle/src/microkubes-java-example/build/gs-rest-service-0.1.0.jar /app/

WORKDIR /app

CMD ["-jar", "gs-rest-service-0.1.0.jar"]
