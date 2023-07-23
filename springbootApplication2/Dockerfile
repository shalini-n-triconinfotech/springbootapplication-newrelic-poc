FROM openjdk:17-alpine
ADD target/relic2-0.0.1-SNAPSHOT.jar relic2-0.0.1-SNAPSHOT.jar
ADD ./newrelic.jar newrelic.jar
ADD ./newrelic.yml newrelic.yml
EXPOSE 8082
ENTRYPOINT ["java","-javaagent:newrelic.jar","-jar","relic2-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java","-jar","relic2-0.0.1-SNAPSHOT.jar"]
