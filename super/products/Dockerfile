FROM openjdk:17-jdk-slim

COPY build/libs/products.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

CMD ["--spring.profiles.active=prod"]
