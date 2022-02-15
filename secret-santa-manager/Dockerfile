FROM openjdk:11
EXPOSE 8080
ADD target/secret-santa.jar secret-santa.jar
ENTRYPOINT ["java","-jar","/secret-santa.jar"]