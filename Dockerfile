FROM openjdk

ADD target/web-0.0.1-SNAPSHOT.jar web.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "web.jar"]