FROM openjdk:11.0.16-jre
WORKDIR /app
COPY ./epidemic-management.jar /app/
EXPOSE 8080
ENV ENVIR pro
CMD nohup java -jar /app/epidemic-management.jar
