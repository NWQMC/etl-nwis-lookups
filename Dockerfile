FROM maven:3.6.0-jdk-11 AS build
LABEL maintainer="gs-w_eto_eb_federal_employees@usgs.gov"

# Add pom.xml and install dependencies
COPY pom.xml /build/pom.xml
WORKDIR /build
COPY oracle/ojdbc6-11.2.0.2.0-1.jar .
RUN mvn install:install-file -Dfile=ojdbc6-11.2.0.2.0-1.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.2.0-1 -Dpackaging=jar
RUN mvn -B dependency:go-offline

# Add source code and (by default) build the jar
COPY src /build/src
RUN mvn -B clean package


FROM usgswma/openjdk:debian-stretch-openjdk-11.0.2-89c4dd2d55ba476c77aa8fd5274dcb8a1ef115b7

COPY --chown=1000:1000 --from=build /build/target/wqp-etl-nwis-lookups-*.jar app.jar

USER $USER

CMD ["java", "-jar", "app.jar"]
