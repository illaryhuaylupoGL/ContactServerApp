CREATE DATABASE `contact` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
CREATE TABLE `tbl_contact` (
  `id` varchar(45) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
