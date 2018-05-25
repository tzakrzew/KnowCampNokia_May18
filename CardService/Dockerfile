FROM anapsix/alpine-java:8_server-jre
COPY build/libs/SecApp-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_HOME=/opt/jdk-9-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.config.location=file:///etc/secret-volume/app.properties"]
