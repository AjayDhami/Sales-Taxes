FROM openjdk:8-jdk-alpine
ADD target/sales-taxes-jar-with-dependencies.jar sales-taxes-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar","sales-taxes-jar-with-dependencies.jar"]