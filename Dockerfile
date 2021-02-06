FROM openjdk:11-jdk AS build

WORKDIR /app

ADD . /app

RUN GRADLE_OPTS="-Dorg.gradle.daemon=false" ./gradlew bootJar

# RUN Container
FROM openjdk:11-slim AS app

EXPOSE 80

COPY --from=build /app/entrypoint.sh /
ENTRYPOINT [ "/entrypoint.sh" ]

WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app
