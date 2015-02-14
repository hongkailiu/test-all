/*
SQLyog Ultimate v9.30 
MySQL - 5.1.73 : Database - mytest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mytest` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `mytest`;

/*Table structure for table `Person` */

DROP TABLE IF EXISTS `Person`;

CREATE TABLE `Person` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `Person` */

insert  into `Person`(`id`,`name`,`country`) values (5,'Pankaj','India'),(6,'Pankaj','India'),(7,'Pankaj',NULL),(8,'Pankaj','India'),(9,'Pankaj','India'),(10,'Pankaj','India'),(11,'Pankaj','India'),(12,'aaa','ccc'),(13,'aaa','ccc'),(14,'aaa','ccc'),(15,'aaa','ccc'),(16,'aaa','ccc'),(17,'aaa','ccc'),(18,'aaa','ccc'),(19,'aaa','ccc'),(20,'aaa','ccc'),(21,'aaa','ccc'),(22,'aaa','ccc'),(23,'aaa','ccc'),(24,'aaa','ccc'),(25,'aaa','ccc'),(26,'aaa','ccc'),(27,'aaa','ccc'),(28,'aaa','ccc'),(29,'aaa','ccc'),(30,'aaa','ccc'),(31,'aaa','ccc'),(32,'aaa','ccc'),(33,'aaa','ccc'),(34,'aaa','ccc'),(35,'aaa','ccc'),(36,'aaa','ccc'),(37,'aaa','ccc'),(38,'aaa','ccc');

/*Table structure for table `certificate` */

DROP TABLE IF EXISTS `certificate`;

CREATE TABLE `certificate` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `person_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_certificate` (`person_id`),
  CONSTRAINT `FK_certificate` FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `certificate` */

insert  into `certificate`(`id`,`name`,`person_id`) values (1,'aaa',6),(2,'aaa',6),(3,'aaa',6),(4,'aaa',6),(5,'bbb',10),(6,'xxx',11),(7,'xxx',11);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
