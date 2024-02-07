FROM amazoncorretto:17.0.9-alpine

WORKDIR /app

COPY ./target/monitor-system-task-1.0.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","monitor-system-task-1.0.jar"]