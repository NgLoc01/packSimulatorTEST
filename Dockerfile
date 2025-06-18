
    # Use Amazon Corretto 21 as the base image
#FROM amazoncorretto:21

    # Create a volume for temporary files
#VOLUME /tmp

    # Copy the built JAR file into the Docker image as app.jar
#COPY build/libs/*.jar app.jar

    # Run the JAR file
#ENTRYPOINT ["java","-jar","/app.jar"]

# Stage 1: Build
FROM gradle:8.5.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build -x test

# Stage 2: Run
FROM eclipse-temurin:21-jre
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


