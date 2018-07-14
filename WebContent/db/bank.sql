﻿# Host: localhost  (Version: 5.5.27)
# Date: 2018-07-14 17:36:38
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "bank"
#

CREATE TABLE `bank` (
  `bid` int(5) NOT NULL AUTO_INCREMENT,
  `bname` varchar(10) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "bank"
#

INSERT INTO `bank` VALUES (1,'工商银行'),(2,'建设银行'),(3,'农业银行'),(4,'华夏银行'),(5,'交通银行'),(6,'秦皇岛银行');

#
# Source for table "user"
#

CREATE TABLE `user` (
  `uid` int(5) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'a','0CC175B9C0F1B6A831C399E269772661'),(3,'c','4A8A08F09D37B73795649038408B5F33'),(4,'d','8277E0910D750195B448797616E091AD'),(5,'e','E1671797C52E15F763380B45E841EC32');

#
# Source for table "ic"
#

CREATE TABLE `ic` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `cnum` int(10) NOT NULL,
  `money` varchar(20) NOT NULL,
  `bid` int(5) DEFAULT NULL,
  `uid` int(5) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `bid` (`bid`),
  KEY `uid` (`uid`),
  CONSTRAINT `ic_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `bank` (`bid`),
  CONSTRAINT `ic_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

#
# Data for table "ic"
#

INSERT INTO `ic` VALUES (13,123,'0',1,3,'2018-07-13'),(14,123,'500',4,3,'2018-07-13'),(35,456,'5000',2,1,'2018-07-04'),(36,456,'5000',3,1,'2018-07-04'),(40,40,'180',6,1,'2018-07-25'),(41,41,'42',4,1,'2018-07-11'),(42,456123,'62',6,1,'2018-07-24');

#
# Source for table "trad"
#

CREATE TABLE `trad` (
  `tid` int(5) NOT NULL AUTO_INCREMENT,
  `type` int(1) DEFAULT '0',
  `money` varchar(20) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `cid` int(5) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `cid` (`cid`),
  CONSTRAINT `trad_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `ic` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

#
# Data for table "trad"
#

INSERT INTO `trad` VALUES (1,1,'100','2018-07-13',40),(2,2,'50','2018-07-14',40),(3,1,'50','2018-07-13',40),(4,2,'50','2018-07-15',40),(5,2,'50','2018-07-13',40),(6,2,'50','2018-07-15',40),(7,2,'50','2018-07-11',40),(8,2,'50','2018-07-18',40),(9,1,'100','2018-07-13',40),(10,1,'200','2018-07-27',40),(11,2,'20','2018-07-19',40),(12,2,'200','2018-07-19',40),(13,2,'200','2018-07-18',40),(14,1,'2000','2018-07-04',40),(15,1,'200','2018-07-10',40),(16,2,'20','2018-07-11',40),(17,0,'200','2018-07-04',40),(18,2,'200','2018-07-25',40),(19,1,'20','2018-07-26',41),(20,1,'22','2018-07-11',41),(21,1,'22','2018-07-17',42),(22,2,'10','2018-07-25',42),(23,1,'50','2018-07-30',42),(24,2,'10','2018-07-10',42),(25,1,'10','2018-07-11',42),(26,1,'10','2018-07-26',42),(27,2,'10','2018-07-24',42);

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
