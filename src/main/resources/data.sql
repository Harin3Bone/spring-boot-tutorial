DROP TABLE IF EXISTS student;

CREATE TABLE student (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(250) NOT NULL,
	language VARCHAR(100) NOT NULL,
	framework VARCHAR(100) NOT NULL
);

INSERT INTO student (id,name,language,framework) VALUES
	(1,'Harin','Java','SpringBoot'),
	(2,'Pawanachai','JavaScript','Nuxt'),
	(3,'Kridsada','TypeScript','Nest'),
	(4,'Tham','Java',''),
	(5,'Aunyamanee','JavaScript','Angular');