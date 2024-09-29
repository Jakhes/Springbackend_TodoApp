# Springbackend_TodoApp
 Springboot Backend for the TodoApp

## Build

To build the jar run `mvn clean package`

And run it with `java -jar ./target/TodoApp-0.0.1-SNAPSHOT.jar`

## Docker

It can be dockerized with the command `docker build --tag=todoapp:latest .` in the rooot folder.

And run as a container with `docker run -p8080:8888 todoapp:latest`.

I changed the port to 8888 because it was conflicting with another programm.

