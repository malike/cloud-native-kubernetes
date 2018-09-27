FROM openjdk:8
VOLUME /tmp
ADD target/java-service-1.0-SNAPSHOT.jar java-service.jar
RUN sh -c 'touch /java-service.jar'
ENV JAVA_OPTS="-Xms64m -Xmx128m"
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /java-service.jar" ]