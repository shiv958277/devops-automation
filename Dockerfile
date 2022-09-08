FROM openjdk:8
EXPOSE 8080
ADD target/jenkins.jar jenkins.jar
ADD configDetails.xml /etc/wadConfig/configDetails.xml
ENTRYPOINT ["java","-jar","jenkins.jar"]