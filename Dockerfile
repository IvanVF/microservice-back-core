FROM openjdk:21
workdir /microservice-back-core
copy /target/app.jar /microservice-back-core/back.jar
ENTRYPOINT ["java", "-jar", "back.jar"]