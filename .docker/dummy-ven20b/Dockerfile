FROM eclipse-temurin:21-jre-alpine

RUN mkdir /opt/oadr-ven20b
RUN mkdir /var/log/oadr-ven20b
RUN mkdir /var/run/oadr-ven20b

COPY --from=openadr-boot3-build:latest /opt/oadr/build/wait-for-it.sh /opt/oadr-ven20b/wait-for-it.sh
COPY --from=openadr-boot3-build:latest /opt/oadr/cert /opt/oadr-ven20b/cert
COPY --from=openadr-boot3-build:latest /opt/oadr/dummy-ven20b/*.jar /opt/oadr-ven20b/
RUN sed -i 's/\r$//' /opt/oadr-ven20b/wait-for-it.sh

COPY realEnergy.registerReport.xml /opt/oadr-ven20b/realEnergy.registerReport.xml
COPY smartEnergyModule.registerReport.xml /opt/oadr-ven20b/smartEnergyModule.registerReport.xml
COPY thermostat.registerReport.xml /opt/oadr-ven20b/thermostat.registerReport.xml
COPY thermostat.full.registerReport.xml /opt/oadr-ven20b/thermostat.full.registerReport.xml
COPY test_certs /opt/oadr-ven20b/test_certs
COPY application.properties /opt/oadr-ven20b/application.properties

RUN mv /opt/oadr-ven20b/*.jar /opt/oadr-ven20b/oadr-ven20b.jar

RUN chmod +x /opt/oadr-ven20b/wait-for-it.sh

CMD [ "java", "-jar", "/opt/oadr-ven20b/oadr-ven20b.jar", "--spring.config.location=/opt/oadr-ven20b/application.properties","-Dhttps.protocols=TLSv1.2"]
