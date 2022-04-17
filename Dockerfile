FROM openjdk:8
WORKDIR /app
COPY ./target/ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar .
CMD ["java", "-jar", "ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]