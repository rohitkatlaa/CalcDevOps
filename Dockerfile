FROM openjdk:8
RUN mkdir -p /app
COPY ./target/ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./app
WORKDIR ./app
CMD ["java", "-jar", "ScientificCalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]