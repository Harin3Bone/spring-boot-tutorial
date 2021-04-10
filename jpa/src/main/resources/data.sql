DROP TABLE IF EXISTS Character;

CREATE TABLE Character (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL,
	class VARCHAR(255),
	label VARCHAR(255),
	level int 	
);

INSERT INTO Character (name,class,label,level) VALUES 
('Zchwarzer','Elementalist','the Orphanage Mage',9),
('Zchperkey','Necromancer','the Apprentice Witch',2),
('Zchmirler','Warrior','the Blood Thirster',5),
('Zchfushta','Ranger','the Hawke Eye',7);