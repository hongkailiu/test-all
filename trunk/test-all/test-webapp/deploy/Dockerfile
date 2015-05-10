FROM nimmis/java-centos:oracle-8-jdk

RUN yum install -y wget unzip

COPY install.sh /install.sh

RUN chmod +x /install.sh && /install.sh

EXPOSE 8080

CMD ["/tomcat_home/apache-tomcat-8.0.22/bin/catalina.sh", "run"]
