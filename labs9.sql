-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: spsc
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_roles` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_roles`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff_name`
--

DROP TABLE IF EXISTS `tariff_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariff_name` (
  `id_tariff` int NOT NULL,
  `name_tariff` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tariff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff_name`
--

LOCK TABLES `tariff_name` WRITE;
/*!40000 ALTER TABLE `tariff_name` DISABLE KEYS */;
INSERT INTO `tariff_name` VALUES (1,'min'),(2,'avg'),(3,'max');
/*!40000 ALTER TABLE `tariff_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(256) NOT NULL,
  `id_roles` int DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FK5i1go2t0eqag1spg3ubr63amq` (`id_roles`),
  CONSTRAINT `FK5i1go2t0eqag1spg3ubr63amq` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id_roles`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'admin@mail.ru','admin','$2a$10$UrAoDC.rjF/c4ZSwWNUuRefSU.2A/Mv4FeG8y/UV44SZeeTp63wXm',1),(3,'123@mail.r','123','$2a$10$HMJEhJeI8GhFRTKLZtRIiO8lmfds8KVNBaK.cNuuKnSfQaE.UF4my',2),(4,'111@mail.r','111','$2a$10$XUrwGZJ26Znu3wklXWaAhuI9VL/mn59iQ8GTynoOUcj0zMEJWqYqq',2),(5,'asd@mail.ru','asd','$2a$10$u894UTCwe0J0.0pqKlSRWOvrSXqqaWGTqDx8LyigwTYLDAc1izPhe',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_phone_number`
--

DROP TABLE IF EXISTS `users_phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_phone_number` (
  `id_user` int NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_phone` varchar(50) DEFAULT NULL,
  `id_tariff` int DEFAULT NULL,
  `deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`id_user`),
  KEY `FK4qhg4g9h1q7ucy4fec0qfwwpd` (`id_tariff`),
  CONSTRAINT `FK4qhg4g9h1q7ucy4fec0qfwwpd` FOREIGN KEY (`id_tariff`) REFERENCES `tariff_name` (`id_tariff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_phone_number`
--

LOCK TABLES `users_phone_number` WRITE;
/*!40000 ALTER TABLE `users_phone_number` DISABLE KEYS */;
INSERT INTO `users_phone_number` VALUES (1,'Алег','89676253816',3,0),(2,'Николай','89761576512',2,0),(3,'Алексей','89667635512',3,0);
/*!40000 ALTER TABLE `users_phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_phone_number_seq`
--

DROP TABLE IF EXISTS `users_phone_number_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_phone_number_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_phone_number_seq`
--

LOCK TABLES `users_phone_number_seq` WRITE;
/*!40000 ALTER TABLE `users_phone_number_seq` DISABLE KEYS */;
INSERT INTO `users_phone_number_seq` VALUES (1);
/*!40000 ALTER TABLE `users_phone_number_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 14:33:18
