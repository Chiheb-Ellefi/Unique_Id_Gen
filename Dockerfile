# Use an OpenJDK image compatible with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the Maven target directory
COPY target/unique_id_generator-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
