--Author: Sandeep Pareek.
--Date: 22nd March 2020
--Create schema for T_NOTE table

CREATE TABLE `T_NOTE` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `description` varchar(20) NOT NULL DEFAULT '',
  `header` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;