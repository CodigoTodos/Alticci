FROM openjdk:11
ARG JAR_FIlE=target/*.jar
COPY ${JAR_FIlE} alticci.jar
ENTRYPOINT ["java","-jar","/alticci.jar"]
EXPOSE 8080

