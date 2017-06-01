/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.13-log : Database - springbootcluster
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootcluster` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootcluster`;

/*Table structure for table `tbl_address` */

DROP TABLE IF EXISTS `tbl_address`;

CREATE TABLE `tbl_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `address` varchar(200) NOT NULL COMMENT '收货地址',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_address` */

insert  into `tbl_address`(`id`,`address`,`remark`) values (1,'福州市仓山区橘园创意广场','地址1');
insert  into `tbl_address`(`id`,`address`,`remark`) values (2,'福州市闽侯县博士后购物广场','地址2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
