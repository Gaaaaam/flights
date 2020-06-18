/*
SQLyog Professional v12.09 (64 bit)
MySQL - 10.1.19-MariaDB : Database - flightsbooker
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flightsbooker` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `flightsbooker`;

/*Table structure for table `flight_order` */

DROP TABLE IF EXISTS `flight_order`;

CREATE TABLE `flight_order` (
  `orderID` varchar(50) CHARACTER SET latin1 NOT NULL,
  `userID` varchar(20) CHARACTER SET latin1 NOT NULL,
  `orderTime` datetime DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `modeOFpayment` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `departurePlace` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `airline` varchar(50) DEFAULT NULL,
  `shippingType` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `departureTime` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `arrivalTime` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `identification` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `flightID` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
