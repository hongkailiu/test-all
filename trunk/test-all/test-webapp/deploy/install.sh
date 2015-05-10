#! /bin/bash

mkdir /tomcat_home
cd /tomcat_home

wget http://apache.mirror.iweb.ca/tomcat/tomcat-8/v8.0.22/bin/apache-tomcat-8.0.22.zip
unzip apache-tomcat-8.0.22.zip

cd /tomcat_home/apache-tomcat-8.0.22/webapps
wget http://hongkailiu.tk/test/file/test-webapp.war

cd /tomcat_home/apache-tomcat-8.0.22/bin
chmod +x ./catalina.sh
