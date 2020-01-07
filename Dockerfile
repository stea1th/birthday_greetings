FROM java:8-jdk-alpine
COPY ./target/birthday_greetings-1.0-SNAPSHOT.war /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "birthday_greetings-1.0-SNAPSHOT.war"]