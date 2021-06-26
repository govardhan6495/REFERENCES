-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: tellbankapp
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `CUSTID` int NOT NULL AUTO_INCREMENT,
  `REFACCNTADDRSS` varchar(45) DEFAULT NULL,
  `REFACCNTNUMBER` varchar(45) DEFAULT NULL,
  `REFACCNTNAME` varchar(45) DEFAULT NULL,
  `IDENDOCNUM` varchar(45) DEFAULT NULL,
  `IDENPROOF` varchar(45) DEFAULT NULL,
  `BRANCHNAME` varchar(45) DEFAULT NULL,
  `INITIALDEPOSIT` int DEFAULT NULL,
  `CITIZENSTATUS` varchar(45) DEFAULT NULL,
  `ACCOUNTTYPE` varchar(45) DEFAULT NULL,
  `RGSTNDATE` varchar(45) DEFAULT NULL,
  `CNCTNO` int DEFAULT NULL,
  `MARITALSTATUS` varchar(45) DEFAULT NULL,
  `GAURDIANTYPE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `COUNTRY` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `NATIONALITY` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `GAURDIAN` varchar(45) DEFAULT NULL,
  `GENDER` varchar(45) DEFAULT NULL,
  `CSTNAME` varchar(45) DEFAULT NULL,
  `USRPSWD` varchar(65) DEFAULT NULL,
  `USRNAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CUSTID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'$2a$10$HlS8bZEr/qTzW3NpUKL/XuT0YcvkXDwNQqD7CdjgEtblEqR9TKv.G','ABD'),(2,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'$2a$10$4PjbzI3J1UaTJd/lyM1xEO/EPrqy42OJSKCD/H4kg02TyhjKo67Vm',NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'$2a$10$MdrtwghfheoCIhLSbfMpCe3CcGQcHQs4vBORlhQXFZvXQ7kdTEa7O',NULL),(4,'564','dfds','test','e4445f','PAN','sdff',452525,'eeee','savings',NULL,88956555,'married','test','neethu@gmail.com','india',NULL,'indian','abc','test','male',NULL,'$2a$10$xIS3zCHRAD7SYKxcu7msj.TU72RGrH/cm/.Fe5blc3ODotQoE5Jse','ABCD'),(5,'564','dfds','test','e4445f','PAN','sdff',452525,'eeee','savings',NULL,88956555,'married','test','neethu@gmail.com','india',NULL,'indian','abc','test','male',NULL,'$2a$10$taBEh999UEq1imFnaKfNeOk9ugN.tBTKgiRlLeZ5BknCr3prL3VNa','ABCED'),(6,'gfgf','434324','rtret','4354','test','test',43543,'test','savings','2021-02-18 00:00:00',434,'Unmarried','major','test@gmail.com','ertret','test','test','rteee','rtt','male','ertret','$2a$10$224.HOetjnG9daUGL9I5KODps9YltvQjwZTg.BY8b.eLNMHDJm90q','rteter'),(7,'32434','2343','32432','324','344','test',234,'32434','savings','2021-02-18 00:00:00',324,'married','major','test@gmail.com','ewrer','ewrewr','werr','errewr','erewr','female','ewrer','$2a$10$5B.aLOELmUjKSW6vDORSteBCJFPrB.MzeUjvz8wJaJHc24FtvrsMS','erewr'),(8,'test','23431','wrewr','34324','test','test',324324,'erwr','savings','2021-02-16 00:00:00',32432,'married','major','test@gmail.com','rerwr','wer','ewrr','ewrewr','ewrew','male','ewrewewr','$2a$10$Wogan7N79rkp9mN0CDWc4Opk6QHSk5exlyD8/ZCVT4dFByuc4j4J2','erwr'),(9,'test','65757','hy','6557','test','test',65765,'test','savings','2021-02-18 00:00:00',657575,'married','major','test@gmail.com','test','test','test','test','yuytu','male','fhrfh','$2a$10$OkfqHB74BzUujeFyfi9pxO0XUvWiBjUi/2lGtv7cP24d1Nst.B0Zm','hjyhj76'),(10,'564','dfds','test','e4445f','PAN','sdff',452525,'eeee','savings',NULL,88956555,'married','test','neethu@gmail.com','india',NULL,'indian','abc','test','male',NULL,'$2a$10$Gq2HO/zI2XmUOoTpop1u4.pbjCB7ciHpgeWWcM.wJu75ASqPX0hL.','EDD'),(11,'test','32431','dfdsf','324324','pan','erwrewr',5000,'test','salary','2021-02-18 00:00:00',43535,'married','major','test@gmail.com','test','test','test','test','test','male','Neethu','$2a$10$Kdx4QNNCPls4w6BL2S0Po.eZM2xGu4X6wvy/zoqBINC2tMaAHYL2S','AQW'),(12,'test','324','fddsf','234324','pan','rewr',10000,'test','savings','2021-02-17 00:00:00',43543,'married','minor','test@gmail.com','test','test','test','test','test','male','Neethu','$2a$10$Dgy3BNK8eWyCPFugss0lQu5NGZxII4sDgxvUUAqoCgBTMykFTDde.','AQER'),(13,'test','32432','rewr','32423','pan','ewrew',10000,'test','savings','2021-02-17 00:00:00',324324,'Unmarried','major','test@gmail.com','test','test','test','Neethu','Neethu','male','Neethu','$2a$10$PvOxqbM8JEjzPp3t6Ke15eeHR2Xt28AMWTf.acT6hl.lFOzWbzq9G','AQERTY'),(14,'test','2132','test','21321','pan','test',10000,'test','savings','2021-02-17 00:00:00',23234,'married','major','test@gmail.com','test','test','test','Neethu','Neethu','male','Neethu','$2a$10$fyAITx2UJnt/6NkDdfYiC.4SUUwAUrH1ErPozv9VrDzgi8CQRleEW','ABCDER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-22 11:50:31
