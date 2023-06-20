FROM openjdk:17-alpine
ADD target/relic-0.0.1-SNAPSHOT.jar relic-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ADD /target/newrelic/newrelic.jar newrelic.jar
ADD ./newrelic.yml newrelic.yml
ENTRYPOINT ["java","-javaagent:newrelic.jar","-jar","relic-0.0.1-SNAPSHOT.jar"]