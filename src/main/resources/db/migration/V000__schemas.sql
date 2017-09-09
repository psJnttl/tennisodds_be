USE `tennisodds`;
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `association` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),

  UNIQUE KEY `unq` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2357 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `tournament`;
CREATE TABLE `tournament` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `name` varchar(200) NOT NULL,
  `association` varchar(10) NOT NULL,
  `surface` varchar(20) DEFAULT NULL,
  `prize_money` double NOT NULL,
  `winner` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq` (`date`,`name`,`association`),
  KEY `winner` (`winner`)
) ENGINE=InnoDB AUTO_INCREMENT=2204 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `tennismatch`;
CREATE TABLE `tennismatch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `tournament` bigint(20) NOT NULL,
  `round` varchar(10) NOT NULL,
  `player1` bigint(20) NOT NULL,
  `player2` bigint(20) NOT NULL,
  `set1` varchar(10) NOT NULL,
  `set2` varchar(10) DEFAULT NULL,
  `set3` varchar(10) DEFAULT NULL,
  `set4` varchar(10) DEFAULT NULL,
  `set5` varchar(10) DEFAULT NULL,
  `odds1` double NOT NULL,
  `odds2` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq` (`date`,`player1`,`player2`),
  KEY `player1` (`player1`),
  KEY `player2` (`player2`),
  KEY `tournament` (`tournament`),
  CONSTRAINT `tennismatch_ibfk_1` FOREIGN KEY (`player1`) REFERENCES `player` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tennismatch_ibfk_2` FOREIGN KEY (`player2`) REFERENCES `player` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tennismatch_ibfk_3` FOREIGN KEY (`tournament`) REFERENCES `tournament` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3114 DEFAULT CHARSET=latin1;
