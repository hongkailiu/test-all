CREATE TABLE Person(id int(10) NOT NULL AUTO_INCREMENT,name varchar(20) NOT NULL DEFAULT '', country varchar(20) DEFAULT NULL,PRIMARY KEY (id))




CREATE TABLE certificate (id int(10) NOT NULL AUTO_INCREMENT,name varchar(30),person_id int(20),PRIMARY KEY (id), FOREIGN KEY (person_id) REFERENCES Person (id)) 


