DROP TABLE IF EXISTS student;

CREATE TABLE STUDENT (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(250) NOT NULL,
	language VARCHAR(100),
	framework VARCHAR(100)
);


INSERT INTO student (name,language,framework) VALUES
	('Harin','Java','SpringBoot'),
	('Pawanachai','JavaScript','Nuxt'),
	('Kridsada','TypeScript','Nest'),
	('Tham','Java',''),
	('Aunyamanee','JavaScript','Angular');