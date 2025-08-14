CREATE TABLE PERSONAS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    edad INT
);

CREATE TABLE CARROS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(255),
    persona_id INT,
    FOREIGN KEY (persona_id) REFERENCES PERSONAS(id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

INSERT INTO PERSONAS (nombre, edad)
VALUES
    ('Carlos', 30),
    ('Ana', 25),
    ('JOSE', 30),
    ('MARIA', 55),
    ('OMAR', 37);

INSERT INTO CARROS(marca, persona_id)
VALUES
    ('MAZDA', 1),
    ('NISSAN', 1),
    ('HONDA', 4),
    ('LANCER', 5);