-- Author: Sandeep Pareek.
-- Date: 22nd March 2020
-- Update date: 23rd April 2023
-- Create schema for T_NOTE table
-- Create schema for T_TAG table
-- Create schema for T_NOTE_TAG table
-- Create T_USER table


CREATE database if NOT EXISTS noteApp;

USE noteApp;

-- This is Note table to store all notes details
CREATE TABLE `T_NOTE` (
	`id` int unsigned NOT NULL auto_increment,
	`description` varchar(20) NOT NULL DEFAULT '',
	`header` varchar(20) NOT NULL,
	`status` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- This is TAG table to store tag details
CREATE TABLE `T_TAG` (
	`tag_id` int unsigned not null auto_increment,
	`tag_name` varchar(30) not null,
	PRIMARY KEY(TAG_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- This is association table of Note and Tag
CREATE TABLE `T_NOTE_TAG` (
	`note_tag_id` int unsigned not null auto_increment,
	`note_id` int unsigned not null,
	`tag_id` int unsigned not null,
	CONSTRAINT note_tag_note foreign key (`note_id`) references T_NOTE(`id`),
	CONSTRAINT note_tag_tag foreign key (`tag_id`) references T_TAG(`tag_id`),
	CONSTRAINT note_tag_unique UNIQUE (`tag_id`, `note_id`),
	PRIMARY KEY (`note_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Altering the original table
ALTER TABLE T_NOTE
Change `header` `title` varchar(1000) NOT NULL;

-- Altering the existing table, but without breaking original table
ALTER TABLE T_NOTE
ADD COLUMN `last_updated_date` timestamp AFTER `status`;

-- User table for authentication and role details
CREATE TABLE IF NOT EXISTS `T_USER` (
	`id` int NOT NULL AUTO_INCREMENT,
	`active` boolean DEFAULT 1,
	`password` varchar(100),
	`username` varchar(50),
	`role` varchar(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Default User `sandy` with BCrypt encoded password `sandy`
INSERT INTO `T_USER` (`active`, `password`, `username`, `role`)
VALUES (1, "$2a$12$0SIyuv8hdhirl9aKiAa70OgYMnDxz3RJcRTkWZac.RQvYeqPEnrJC", "sandy", "ROLE_ADMIN");
