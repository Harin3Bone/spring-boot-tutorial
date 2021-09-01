DROP TABLE IF EXISTS LaipaireoiPodcast;

CREATE TABLE Member (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL,
	job VARCHAR(100) NOT NULL DEFAULT '',
	lang VARCHAR(100) NOT NULL DEFAULT ''
);

INSERT INTO Member (id,name,job,lang) VALUES 
(1,'Harin','Backend Developer','Java'),
(2,'Kridsada','Backend Developer','TypeScript'),
(3,'Pawanachai','Frontend Developer','TypeScript')