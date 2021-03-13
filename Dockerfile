FROM openjdk:8
EXPOSE 8081:8081
ADD target/casestudy-1.war casestudy-1.war
ENTRYPOINT ["java", "-jar", "casestudy-1.war"]