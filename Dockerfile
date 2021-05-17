FROM openjdk:8
MAINTAINER Kumaranraj
EXPOSE 8080
ADD target/prod-app.jar prod-app.jar
ENTRYPOINT ["java","-jar","prod-app.jar"]
