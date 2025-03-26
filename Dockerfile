# Use OpenJDK base image
FROM openjdk:23

# Set working directory
WORKDIR /app

# Copy JAR file from build
COPY target/QBConnectorService-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]