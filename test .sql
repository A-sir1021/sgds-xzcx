/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.6.42 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) DEFAULT NULL,
  `comment` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

insert  into `comment`(`id`,`comment`) values 
(1,'good');

/*Table structure for table `hangle` */

DROP TABLE IF EXISTS `hangle`;

CREATE TABLE `hangle` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `firm` varchar(50) DEFAULT NULL,
  `consumer` varchar(50) DEFAULT NULL,
  `ship` varchar(50) DEFAULT NULL,
  `delivery` varchar(50) DEFAULT NULL,
  `logistic` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hangle` */

insert  into `hangle`(`id`,`name`,`firm`,`consumer`,`ship`,`delivery`,`logistic`) values 
(1,'zhangsan','123','123','123','213','123');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `zindex` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `manager` */

insert  into `manager`(`id`,`username`,`password`,`pid`,`zindex`) values 
(1,'zhangsan','123','123','123');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  `istype` int(11) DEFAULT NULL,
  `descpt` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `page` varchar(50) DEFAULT NULL,
  `insert_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`pid`,`zindex`,`istype`,`descpt`,`code`,`icon`,`page`,`insert_time`,`update_time`) values 
(1,'zhangsan',123,123,123,'123','213','123','123','2018-11-13','2018-11-13');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `permise` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`description`,`price`,`date`,`permise`) values 
(1,'zhangsan','213',123,'2018-11-14 16:33:19','123');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  `descpt` varchar(40) DEFAULT NULL,
  `code` varchar(40) DEFAULT NULL,
  `insert_uid` int(11) DEFAULT NULL,
  `insert_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`,`descpt`,`code`,`insert_uid`,`insert_time`,`update_time`) values 
(1,'zhangsan','123','123',123,'2018-10-31','2018-11-14');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `last_login_time` date DEFAULT NULL,
  `last_login_ip` varchar(50) DEFAULT NULL,
  `mobile` varchar(40) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`last_login_time`,`last_login_ip`,`mobile`,`email`) values 
(1,'zhangsan','123','2018-12-01','213','123','213');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
