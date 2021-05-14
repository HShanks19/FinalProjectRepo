FROM maven:3.6.3-openjdk-11-slim AS build-stage
COPY . /build
WORKDIR /build
RUN mvn package install

FROM openjdk:11-slim as run-time
WORKDIR /app
COPY --from=build-stage /home/jenkins/.m2/repository/com/qa/FinalProjectCitizenRepo/0.0.1-SNAPSHOT/FinalProjectCitizenRepo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "finalprojectcitizenrepo.jar"]