FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/matchmaker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT java -Dserver.port=10000 -Dspring.profiles.active=real -Dspring.cloud.vault.token=${VAULT_TOKEN} -jar app.jar