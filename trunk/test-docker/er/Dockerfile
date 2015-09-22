FROM tomcat:7.0.64-jre8

COPY install.sh /install.sh

COPY eventrepository-erall.rules /usr/local/tomcat/eventrepository-erall.rules

COPY eventrepository-erall.cfg /usr/local/tomcat/eventrepository-erall.cfg

RUN chmod +x /install.sh && /install.sh

EXPOSE 8080

CMD ["catalina.sh", "run"]
