FROM openjdk:jdk
WORKDIR /appcontainer
EXPOSE 9198
COPY ./target/auth-service-ms.jar /appcontainer
ADD ./target/auth-service-ms.jar auth-service-ms.jar
ENTRYPOINT ["java","-jar","auth-service-ms.jar"]