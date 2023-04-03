FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/spring-jwt.jar .
EXPOSE 8080
CMD ["java", "-jar", "spring-jwt.jar"]