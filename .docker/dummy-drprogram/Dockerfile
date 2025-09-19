FROM eclipse-temurin:21-jre-alpine

RUN mkdir /opt/dummy-drprogram
RUN mkdir /var/log/dummy-drprogram
RUN mkdir /var/run/dummy-drprogram

COPY --from=openadr-boot3-build:latest /opt/oadr/build/wait-for-it.sh /opt/dummy-drprogram/wait-for-it.sh
COPY --from=openadr-boot3-build:latest /opt/oadr/cert /opt/dummy-drprogram/cert
COPY --from=openadr-boot3-build:latest /opt/oadr/dummy-drprogram/*.jar /opt/dummy-drprogram/
RUN sed -i 's/\r$//' /opt/dummy-drprogram/wait-for-it.sh

COPY simple.DemandResponseEventCreateDto.json /opt/dummy-drprogram/simple.DemandResponseEventCreateDto.json
COPY fastDR.DemandResponseEventCreateDto.json /opt/dummy-drprogram/fastDR.DemandResponseEventCreateDto.json
COPY thermostat.DemandResponseEventCreateDto.json /opt/dummy-drprogram/thermostat.DemandResponseEventCreateDto.json

COPY application.properties /opt/dummy-drprogram/application.properties

RUN mv /opt/dummy-drprogram/*.jar /opt/dummy-drprogram/dummy-drprogram.jar

RUN chmod +x /opt/dummy-drprogram/wait-for-it.sh

CMD ["java", "-jar", "/opt/dummy-drprogram/dummy-drprogram.jar","--spring.config.location=/opt/dummy-drprogram/application.properties"]