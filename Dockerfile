FROM openjdk:13
VOLUME /tmp
EXPOSE 8020

ADD ./target/invoice-service-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]