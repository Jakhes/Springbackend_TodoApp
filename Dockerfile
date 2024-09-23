FROM openjdk:21-jdk
COPY target/TodoApp-0.0.1-SNAPSHOT.jar TodoApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TodoApp-0.0.1-SNAPSHOT.jar"]