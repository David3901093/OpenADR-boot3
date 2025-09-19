FROM eclipse-temurin:21-jre-alpine

RUN mkdir /opt/oadr-vtn20b/
RUN mkdir /opt/oadr-vtn20b/lib
RUN mkdir /opt/oadr-vtn20b/classes
RUN mkdir /var/log/oadr-vtn20b
RUN mkdir /var/run/oadr-vtn20b

COPY --from=openadr-boot3-build:latest /opt/oadr/build/wait-for-it.sh /opt/oadr-vtn20b/wait-for-it.sh
COPY --from=openadr-boot3-build:latest /opt/oadr/cert /opt/oadr-vtn20b/cert
COPY --from=openadr-boot3-build:latest /opt/oadr/vtn20b/*.jar /opt/oadr-vtn20b/
COPY --from=openadr-boot3-build:latest /opt/oadr/lib/* /opt/oadr-vtn20b/lib/

COPY application.properties /opt/oadr-vtn20b/application.properties
COPY loader.properties /opt/oadr-vtn20b/loader.properties
COPY log4j2.xml /opt/oadr-vtn20b/log4j2.xml
COPY oadr-vtn20b.conf /opt/oadr-vtn20b/oadr-vtn20b.conf


RUN mv /opt/oadr-vtn20b/*.jar /opt/oadr-vtn20b/oadr-vtn20b.jar


RUN ls -l /opt/oadr-vtn20b/
RUN unzip -q /opt/oadr-vtn20b/oadr-vtn20b.jar -d /opt/oadr-vtn20b/
RUN mv /opt/oadr-vtn20b/BOOT-INF/classes/* /opt/oadr-vtn20b/classes/
RUN mv /opt/oadr-vtn20b/BOOT-INF/lib/* /opt/oadr-vtn20b/lib/
RUN rm -rf /opt/oadr-vtn20b/BOOT-INF /opt/oadr-vtn20b/META-INF /opt/oadr-vtn20b/oadr-vtn20b.jar

RUN sed -i 's/\r$//' /opt/oadr-vtn20b/wait-for-it.sh
RUN chmod +x /opt/oadr-vtn20b/wait-for-it.sh

CMD [ "java", \
  "--add-opens", "java.base/java.lang=ALL-UNNAMED", \
  "--add-opens", "java.base/java.util=ALL-UNNAMED", \
  "--add-opens", "java.base/java.lang.reflect=ALL-UNNAMED", \
  "-cp", "/opt/oadr-vtn20b/classes:/opt/oadr-vtn20b/lib/*", \
  "com.avob.openadr.server.oadr20b.vtn.VTN20bApplication", \
  "--spring.config.location=/opt/oadr-vtn20b/application.properties" ]
