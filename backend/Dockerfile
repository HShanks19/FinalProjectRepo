FROM maven:3.6.3-openjdk-11-slim AS build-stage
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM openjdk:11-slim as run-time
WORKDIR /app
COPY --from=build-stage /build/target/FinalProjectCitizenRepo-0.0.1-SNAPSHOT.jar /app/FinalProjectCitizenRepo.jar
EXPOSE 5001
ENTRYPOINT ["java", "-jar", "FinalProjectCitizenRepo.jar"]