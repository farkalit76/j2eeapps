delimiter $$

CREATE TABLE `lib_info` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `established` datetime NOT NULL,
  `founder` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `book_catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `printing_year` datetime NOT NULL,
  `pages` smallint(6) DEFAULT NULL,
  `available` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `className` varchar(45) NOT NULL,
  `birthDate` datetime NOT NULL,
  `sex` char(1) NOT NULL DEFAULT 'M',
  `section` varchar(30) NOT NULL,
  `admissionYear` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$