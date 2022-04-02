FROM openjdk:8
COPY ./target/ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]