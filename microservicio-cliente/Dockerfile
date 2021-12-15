FROM adoptopenjdk:11-jre-hotspot as builder

RUN apt-get install -y tzdata

ENV TZ America/Bogota

VOLUME ["/home"]

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "/home/microservicio-cliente-0.0.1-SNAPSHOT.jar"]