-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: pizzabusinesdb
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_city` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_state` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_zip` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (2,'phuly2','hanam3','hiennt','0912791323','vn','777777788');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_invoice`
--

DROP TABLE IF EXISTS `tbl_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_invoice` (
  `cus_id` int(11) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `issue_date` datetime DEFAULT NULL,
  `numbers` int(11) DEFAULT NULL,
  `total_payment` float DEFAULT NULL,
  PRIMARY KEY (`cus_id`,`pro_id`),
  KEY `FK8vk7t2deu6biex42c896dq17s` (`pro_id`),
  CONSTRAINT `FK8vk7t2deu6biex42c896dq17s` FOREIGN KEY (`pro_id`) REFERENCES `tbl_product` (`pro_id`),
  CONSTRAINT `FKk5w1a0px2xkxv89ar37vkp2fk` FOREIGN KEY (`cus_id`) REFERENCES `tbl_customer` (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_invoice`
--

LOCK TABLES `tbl_invoice` WRITE;
/*!40000 ALTER TABLE `tbl_invoice` DISABLE KEYS */;
INSERT INTO `tbl_invoice` VALUES (2,2,'2017-12-01 12:27:09',2,3333);
/*!40000 ALTER TABLE `tbl_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_details` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pro_images` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pro_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pro_unit_price` float DEFAULT NULL,
  `prt_id` int(11) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FKs9dpea5l9x9unj7gkj2gqo6u1` (`prt_id`),
  CONSTRAINT `FKs9dpea5l9x9unj7gkj2gqo6u1` FOREIGN KEY (`prt_id`) REFERENCES `tbl_protype` (`prt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,'dfgdfgdfgd','fgdfg','hrhr',100,1),(2,'sdfsdfs','sdfsdf','gtgt',111,2);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_protype`
--

DROP TABLE IF EXISTS `tbl_protype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_protype` (
  `prt_id` int(11) NOT NULL AUTO_INCREMENT,
  `prt_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`prt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_protype`
--

LOCK TABLES `tbl_protype` WRITE;
/*!40000 ALTER TABLE `tbl_protype` DISABLE KEYS */;
INSERT INTO `tbl_protype` VALUES (1,'ttt'),(2,'eee'),(4,'uuu'),(5,'tttt');
/*!40000 ALTER TABLE `tbl_protype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-01 18:06:59
