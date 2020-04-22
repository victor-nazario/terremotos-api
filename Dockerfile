FROM openjdk:8
ADD target/terremotos-api.jar terremotos-api.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "terremotos-api.jar"]