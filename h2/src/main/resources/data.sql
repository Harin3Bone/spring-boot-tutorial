DROP TABLE IF EXISTS user;

CREATE TABLE USER (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(250) NOT NULL,
	language VARCHAR(100),
	framework VARCHAR(100)
);


INSERT INTO user (name,language,framework) VALUES
	('Harin','Java','SpringBoot'),
	('Pawanachai','JavaScript','Nuxt'),
	('Kridsada','TypeScript','Nest'),
	('Tham','Java',''),
	('Watcharapol','Python','');