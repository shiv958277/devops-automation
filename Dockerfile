FROM openjdk:8
EXPOSE 8080
ADD target/jenkins.war jenkins.war
ENTRYPOINT ["java","-war,"/jenkins.war"]
	