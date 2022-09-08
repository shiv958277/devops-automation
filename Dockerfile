FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD target/jenkins.jar jenkins.jar
COPY /target/jenkins.jar jenkins.jar
ENTRYPOINT ["java","-jar","jenkins.jar"]