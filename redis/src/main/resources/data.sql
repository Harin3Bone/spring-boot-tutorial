
DROP TABLE IF EXISTS console;

CREATE TABLE console (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL,
	company VARCHAR(255) 	
);

INSERT INTO console (id,name,company) VALUES 
(1,'PlayStation','Sony'),
(2,'XBox','Microsoft'),
(3,'Gameboy','Nintendo')