#! /bin/bash

echo 'export JAVA_OPTS=-Dcom.ericsson.duraci.er.config.file=/usr/local/tomcat/eventrepository-erall.cfg' > /usr/local/tomcat/bin/setenv.sh

curl -o /usr/local/tomcat/webapps/eventrepository.war https://arm101-eiffel006.lmera.ericsson.se:8443/nexus/content/repositories/releases/com/ericsson/duraci/eventrepository/26.0.3/eventrepository-26.0.3.war
