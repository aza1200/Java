-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.4.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- music_player 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `music_player` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `music_player`;

-- 테이블 music_player.album 구조 내보내기
CREATE TABLE IF NOT EXISTS `album` (
  `Album_Ssn` varchar(20) NOT NULL,
  `Artist_Name` varchar(20) NOT NULL,
  `Album_Birth` varchar(20) NOT NULL,
  `Songs_Num` int(11) NOT NULL,
  PRIMARY KEY (`Album_Ssn`),
  KEY `Artist_Num_fk` (`Artist_Name`),
  CONSTRAINT `Artist_Num_fk` FOREIGN KEY (`Artist_Name`) REFERENCES `artist` (`Art_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.album:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` (`Album_Ssn`, `Artist_Name`, `Album_Birth`, `Songs_Num`) VALUES
	('2', 'Big_Bang', '2019-20-02', 399);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;

-- 테이블 music_player.artist 구조 내보내기
CREATE TABLE IF NOT EXISTS `artist` (
  `Art_Name` varchar(20) NOT NULL,
  `Music_Num` int(11) NOT NULL,
  `Album_Num` int(11) NOT NULL,
  `IN_group` varchar(20) NOT NULL,
  PRIMARY KEY (`Art_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.artist:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` (`Art_Name`, `Music_Num`, `Album_Num`, `IN_group`) VALUES
	('Big_Bang', 30, 40, 'ToOP'),
	('Zico', 20, 20, 'SOLO');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;

-- 테이블 music_player.manager 구조 내보내기
CREATE TABLE IF NOT EXISTS `manager` (
  `Mgr_ID` varchar(20) NOT NULL,
  `Mgr_Name` varchar(20) NOT NULL,
  PRIMARY KEY (`Mgr_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.manager:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`Mgr_ID`, `Mgr_Name`) VALUES
	('aza1200', 'Jae-Hyeong'),
	('dienstar', 'Dien');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 테이블 music_player.music 구조 내보내기
CREATE TABLE IF NOT EXISTS `music` (
  `Music_Ssn` varchar(20) NOT NULL,
  `Mg_ID` varchar(20) NOT NULL,
  `Mu_Name` varchar(20) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  PRIMARY KEY (`Music_Ssn`),
  KEY `MG_ID_fk` (`Mg_ID`),
  CONSTRAINT `MG_ID_fk` FOREIGN KEY (`Mg_ID`) REFERENCES `manager` (`Mgr_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.music:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` (`Music_Ssn`, `Mg_ID`, `Mu_Name`, `Genre`) VALUES
	('1', 'aza1200', 'Keeping_your_head_up', 'Pop'),
	('2', 'aza1200', 'Loser', 'K-POP');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

-- 테이블 music_player.music_coupon 구조 내보내기
CREATE TABLE IF NOT EXISTS `music_coupon` (
  `Service_num` varchar(20) NOT NULL,
  `Service_name` varchar(20) NOT NULL,
  `Price` int(11) NOT NULL,
  `Validity` varchar(20) NOT NULL,
  PRIMARY KEY (`Service_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.music_coupon:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `music_coupon` DISABLE KEYS */;
INSERT INTO `music_coupon` (`Service_num`, `Service_name`, `Price`, `Validity`) VALUES
	('1', 'One_month_free', 3000, '2020-12-31'),
	('2', 'Free', 2000000, '3000');
/*!40000 ALTER TABLE `music_coupon` ENABLE KEYS */;

-- 테이블 music_player.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `Account_num` varchar(20) NOT NULL,
  `Service_Num` varchar(20) NOT NULL,
  `Pay_way` varchar(20) NOT NULL,
  PRIMARY KEY (`Account_num`),
  KEY `Service_Num_fk` (`Service_Num`),
  CONSTRAINT `Service_Num_fk` FOREIGN KEY (`Service_Num`) REFERENCES `music_coupon` (`Service_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.payment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 music_player.playlist 구조 내보내기
CREATE TABLE IF NOT EXISTS `playlist` (
  `List_Ssn` varchar(20) NOT NULL,
  `Song_num` int(11) NOT NULL,
  `Userof_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`List_Ssn`),
  KEY `Userof_ID_fk` (`Userof_ID`),
  CONSTRAINT `Userof_ID_fk` FOREIGN KEY (`Userof_ID`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.playlist:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` (`List_Ssn`, `Song_num`, `Userof_ID`) VALUES
	('1', 21, 'aza1200');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;

-- 테이블 music_player.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `User_ID` varchar(20) NOT NULL,
  `Coupon_num` varchar(20) NOT NULL,
  `User_nickname` varchar(20) NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `Coupon_num_fk` (`Coupon_num`),
  CONSTRAINT `Coupon_num_fk` FOREIGN KEY (`Coupon_num`) REFERENCES `music_coupon` (`Service_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 music_player.user:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`User_ID`, `Coupon_num`, `User_nickname`) VALUES
	('aza1200', '2', 'Kim_Jae_Hyeong'),
	('azzzz', '1', 'Babe');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
