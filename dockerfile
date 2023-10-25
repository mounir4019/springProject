# Base image
 FROM  maven:3.9-sapmachine-17   AS build 
 WORKDIR /app
# Copy the project source 
 COPY . /app
# Build the JAR file
  RUN mvn -e clean install   package -DskipTests
 
# Base image for the production image
 FROM openjdk:17 
# Copy the JAR file from the build image
 COPY --from=build /app/target/*.jar /app/springProject.jar
 EXPOSE 8080
# Set the entrypoint
 ENTRYPOINT ["java", "-jar", "/app/springProject.jar"] 

#CMD ["java", "-jar", "/app/app.jar"]
#FROM openjdk:17 
#WORKDIR /app
# ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} /app/springproject.jar 
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app/springproject.jar"]
#CMD ["java", "-jar", "/app/app.jar"]

######FROM openjdk:17 
##### ARG JAR_FILE=target/*.jar
#####COPY target/springProject-0.0.1-SNAPSHOT.jar .
#####EXPOSE 8080
######ENTRYPOINT ["java","-jar","/springProject-0.0.1-SNAPSHOT.jar"]