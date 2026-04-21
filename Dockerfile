# Etapa 1: build
FROM gradle:8.14-jdk21 AS build
WORKDIR /app
COPY . .

RUN chmod +x gradlew
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]