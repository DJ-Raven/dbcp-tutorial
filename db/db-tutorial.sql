/*
Navicat MySQL Data Transfer

Source Server         : SERVER-3305
Source Server Version : 50620
Source Host           : localhost:3305
Source Database       : db-tutorial

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2024-05-19 21:47:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ProductID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `QtyStock` int(11) DEFAULT '0',
  `SellPrice` float(10,2) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `DeletedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
