FROM openjdk:11
ARG JAR_FILE=build/libs/MediscreenAssessmentApi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} MediscreenAssessmentApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/MediscreenAssessmentApi-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083