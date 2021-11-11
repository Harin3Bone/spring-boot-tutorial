
DROP TABLE IF EXISTS Character;

CREATE TABLE Character (
	id LONG AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) UNIQUE NOT NULL,
	class VARCHAR(255),
	label VARCHAR(255),
	level int 	
);

INSERT INTO Character (id,name,class,label,level) VALUES 
(1,'Zchwarzer','Elementalist','the Orphanage Mage',9),
(2,'Zchperkey','Necromancer','the Apprentice Witch',2),
(3,'Zchmirler','Warrior','the Blood Thirster',5),
(4,'Zchfushta','Ranger','the Hawke Eye',7);