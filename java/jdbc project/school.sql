-- MySQL dump 10.19  Distrib 10.3.39-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	10.3.39-MariaDB-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fyc`
--

DROP TABLE IF EXISTS `fyc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fyc` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fyc`
--

LOCK TABLES `fyc` WRITE;
/*!40000 ALTER TABLE `fyc` DISABLE KEYS */;
/*!40000 ALTER TABLE `fyc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sya`
--

DROP TABLE IF EXISTS `sya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sya` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sya`
--

LOCK TABLES `sya` WRITE;
/*!40000 ALTER TABLE `sya` DISABLE KEYS */;
INSERT INTO `sya` VALUES (1,'Ravi',39,29,43,29),(2,'Suresh',29,33,55,43),(3,'Ramesh',26,49,32,27),(4,'Mahesh',49,33,27,47),(5,'Rajesh',59,59,54,36),(6,'Santosh',29,48,55,34),(7,'Manoj',53,30,39,43),(8,'Sunil',40,44,39,39),(9,'Anil',54,58,29,55),(10,'Mukesh',54,46,44,55),(11,'Rahul',50,59,47,35),(12,'Vijay',44,54,42,60),(13,'Ajay',41,37,37,48),(14,'Sanjay',34,38,27,30),(15,'Dinesh',48,52,54,54);
/*!40000 ALTER TABLE `sya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syb`
--

DROP TABLE IF EXISTS `syb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syb` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syb`
--

LOCK TABLES `syb` WRITE;
/*!40000 ALTER TABLE `syb` DISABLE KEYS */;
INSERT INTO `syb` VALUES (1,'Ravi',50,25,60,56),(2,'Anita',40,45,42,51),(3,'Ramesh',34,30,56,58),(4,'Sunita',26,40,26,57),(5,'Rajesh',39,33,25,38),(6,'Geeta',55,26,50,41),(7,'Sunil',31,41,53,47);
/*!40000 ALTER TABLE `syb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syc`
--

DROP TABLE IF EXISTS `syc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syc` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syc`
--

LOCK TABLES `syc` WRITE;
/*!40000 ALTER TABLE `syc` DISABLE KEYS */;
INSERT INTO `syc` VALUES (2,'pruthvi',60,60,60,60),(3,'ajay',56,60,55,59),(4,'sami',40,35,40,35),(5,'arron',60,25,30,50),(6,'amar',28,38,46,54),(7,'digambar',35,26,35,37),(8,'maaj',55,33,49,47),(9,'malhar',28,48,57,44),(10,'sachin',27,48,27,37),(11,'prathamesh',46,58,54,37),(12,'harsh',36,44,50,56),(13,'pruthviraj',37,25,29,42),(14,'radhey',29,29,36,31),(15,'yash',59,34,40,39),(16,'om',50,37,45,56),(17,'pawan',46,40,35,32),(18,'kaif',31,33,48,45),(19,'aryan',55,43,28,58),(20,'rohan',34,54,34,54),(21,'om raut',50,50,50,50),(22,'om bhanu',40,40,40,40);
/*!40000 ALTER TABLE `syc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tya`
--

DROP TABLE IF EXISTS `tya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tya` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tya`
--

LOCK TABLES `tya` WRITE;
/*!40000 ALTER TABLE `tya` DISABLE KEYS */;
INSERT INTO `tya` VALUES (1,'Amit',48,42,39,45),(2,'Sneha',48,45,58,57),(3,'Vikas',52,27,29,37),(4,'Pooja',38,54,58,32);
/*!40000 ALTER TABLE `tya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tyb`
--

DROP TABLE IF EXISTS `tyb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tyb` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tyb`
--

LOCK TABLES `tyb` WRITE;
/*!40000 ALTER TABLE `tyb` DISABLE KEYS */;
INSERT INTO `tyb` VALUES (1,'Rohit',34,50,50,40),(2,'Anjali',28,28,33,55),(3,'Sachin',43,27,54,57),(4,'Ritu',26,41,33,54);
/*!40000 ALTER TABLE `tyb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tyc`
--

DROP TABLE IF EXISTS `tyc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tyc` (
  `Rollno` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `Physics` int(11) DEFAULT NULL,
  `Maths` int(11) DEFAULT NULL,
  `Chemistry` int(11) DEFAULT NULL,
  `Biology` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tyc`
--

LOCK TABLES `tyc` WRITE;
/*!40000 ALTER TABLE `tyc` DISABLE KEYS */;
INSERT INTO `tyc` VALUES (1,'Alok',39,42,33,53),(2,'Meena',30,40,50,32),(3,'Rajat',57,58,56,49),(4,'Sarita',51,46,55,41);
/*!40000 ALTER TABLE `tyc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-02 11:26:25
