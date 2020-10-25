--Author: Sandeep Pareek.
--Date: 22nd March 2020
--Update date: 25th Oct, 2020
--Create schema for T_NOTE table
--Create schema for T_TAG table
--Create schema for T_NOTE_TAG table
--Create T_USER table


CREATE database if NOT EXISTS noteApp;

USE noteApp;

-- This is Note table to store all notes details
CREATE TABLE `T_NOTE` (
	`id` int(11) unsigned NOT NULL auto_increment,
	`description` varchar(20) NOT NULL DEFAULT '',
	`header` varchar(20) NOT NULL,
	`status` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- This is TAG table to store tag details
CREATE TABLE `T_TAG` (
	`tag_id` int unsigned not null auto_increment,
	`tag_name` varchar(30) not null,
	PRIMARY KEY(TAG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- This is association table of Note and Tag
CREATE TABLE `T_NOTE_TAG` (
	`note_tag_id` int unsigned not null auto_increment,
	`note_id` int unsigned not null,
	`tag_id` int unsigned not null,
	CONSTRAINT note_tag_note foreign key (`note_id`) references T_NOTE(`id`),
	CONSTRAINT note_tag_tag foreign key (`tag_id`) references T_TAG(`tag_id`),
	CONSTRAINT note_tag_unique UNIQUE (`tag_id`, `note_id`),
	PRIMARY KEY (`note_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Altering the original table
ALTER TABLE T_NOTE
Change `header` `title` varchar(1000) NOT NULL;

-- Altering the existing table, but without breaking orginal table
ALTER TABLE T_NOTE
ADD COLUMN `last_updated_date` timestamp AFTER `status`;

-- User table for authentication and role details
CREATE TABLE IF NOT EXISTS `T_USER` (
	`id` int(100) NOT NULL AUTO_INCREMENT,
	`active` boolean DEFAULT 1,
	`password` varchar(50),
	`username` varchar(50),
	`role` varchar(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


