-- H2 Database
--DROP TABLE IF EXISTS Servant;
--
--CREATE TABLE Servant (
--	`id` LONG AUTO_INCREMENT PRIMARY KEY,
--	`name` VARCHAR(255) UNIQUE NOT NULL,
--	`class` VARCHAR(50) NOT NULL,
--	rarity VARCHAR(10) NOT NULL,
--	myth VARCHAR(255)
--);

-- MySQL
--DROP TABLE IF EXISTS Servant;
--
--CREATE TABLE Servant (
--`id` INT(11) NOT NULL AUTO_INCREMENT,
--`name` VARCHAR(255) UNIQUE DEFAULT '' NOT NULL,
--`class` VARCHAR(50) DEFAULT '' NOT NULL,
--`rarity` VARCHAR(10) DEFAULT '' NOT NULL,
--`myth` VARCHAR(255),
--PRIMARY KEY (id)
--) Engine=InnoDB;

-- PostgreSQL
DROP TABLE IF EXISTS Servant;
DROP SEQUENCE IF EXISTS servant_id;

CREATE SEQUENCE servant_id;

CREATE TABLE Servant (
	id INT8 NOT NULL DEFAULT(NEXTVAL('servant_id')),
	name VARCHAR(255) UNIQUE NOT NULL,
	class VARCHAR(50) NOT NULL,
	rarity VARCHAR(10) NOT NULL,
	myth VARCHAR(255),
	PRIMARY KEY (id)
);