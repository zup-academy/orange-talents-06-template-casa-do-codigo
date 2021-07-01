CREATE TABLE categoria(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria(nome) VALUES ('01 categoria');
INSERT INTO categoria(nome) VALUES ('02 categoria');
INSERT INTO categoria(nome) VALUES ('03 categoria');