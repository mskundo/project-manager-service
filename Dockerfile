FROM openjdk:8
ADD target/ProjectManager-0.0.1-SNAPSHOT.jar ProjectManager-0.0.1-SNAPSHOT.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "ProjectManager-0.0.1-SNAPSHOT.jar"]