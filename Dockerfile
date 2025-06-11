# 1. Aşama: Maven ile proje derleniyor
FROM maven:3.9.6-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Aşama: Sadece derlenmiş .jar dosyasını içeren minimal imaj
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/ECommerceFinal-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
