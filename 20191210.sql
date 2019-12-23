/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.27-log : Database - db1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db1`;

/*Table structure for table `db1_user` */

DROP TABLE IF EXISTS `db1_user`;

CREATE TABLE `db1_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '登录用户名',
  `user_pwd` varchar(50) NOT NULL COMMENT '密码',
  `user_nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `gender` enum('男','女') NOT NULL DEFAULT '男' COMMENT '性别',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `mobile_phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(20) DEFAULT NULL COMMENT '固话(座机号码)',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;








/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.27-log : Database - db2
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db2`;

/*Table structure for table `db2_user` */

DROP TABLE IF EXISTS `db2_user`;

CREATE TABLE `db2_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '登录用户名',
  `user_pwd` varchar(50) NOT NULL COMMENT '密码',
  `user_nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `gender` enum('男','女') NOT NULL DEFAULT '男' COMMENT '性别',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `mobile_phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(20) DEFAULT NULL COMMENT '固话(座机号码)',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;








