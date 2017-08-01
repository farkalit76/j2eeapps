CREATE TABLE `employee2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `age` smallint(6) NOT NULL,
  `sex` char(1) NOT NULL,
  `education` varchar(45) DEFAULT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1$$
