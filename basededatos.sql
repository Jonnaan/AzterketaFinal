drop database if exists mascotas_db;
CREATE DATABASE if not exists mascotas_db;

use mascotas_db;

CREATE TABLE Gato (
	izena VARCHAR(100),
    adina INT,
    NAN_Jabe VARCHAR(20),
    id INT,
    kolorea VARCHAR(50),
    ileLuzea VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE Perro (
	izena VARCHAR(100),
    adina INT,
    NAN_Jabe VARCHAR(20),
    id INT,
    arraza VARCHAR(50),
    arkakusoak BOOLEAN,
    PRIMARY KEY (id)
);

INSERT INTO Gato (id, izena, adina, NAN_Jabe, kolorea, ileLuzea) 
VALUES 
(1, 'Tom', 3, '12345678A', 'negro', 'largo'),
(2, 'Mimi', 2, '87654321B', 'blanco', 'corto');
INSERT INTO Perro (id, izena, adina, NAN_Jabe, arraza, arkakusoak) 
VALUES 
(1, 'Spike', 5, '23456789C', 'bulldog', false),
(2, 'Rex', 4, '98765432D', 'pastor alemán', true);


CREATE VIEW mascotas AS
SELECT 
    'Gato' AS tipo,
    id,
    izena,
    adina,
    NAN_Jabe,
    kolorea AS atributo1,
    ileLuzea AS atributo2,
    NULL AS atributo3
FROM 
    Gato
UNION
SELECT 
    'Perro' AS tipo,
    id,
    izena,
    adina,
    NAN_Jabe,
    arraza AS arraza,
    NULL AS atributo2,
    arkakusoak AS atributo3
FROM 
    Perro;