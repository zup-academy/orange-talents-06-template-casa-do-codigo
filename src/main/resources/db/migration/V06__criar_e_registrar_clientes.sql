CREATE TABLE cliente(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	documento VARCHAR(14) NOT NULL,
	endereco VARCHAR(50) NOT NULL,
	complemento VARCHAR(50),
	cidade VARCHAR(50) NOT NULL,
	pais_codigo BIGINT(20) NOT NULL,
	estado_codigo BIGINT(20) NOT NULL,
	telefone BIGINT(9) NOT NULL,
	cep BIGINT(8) NOT NULL   
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `cliente` ADD CONSTRAINT `fk_pais_cl` FOREIGN KEY ( `pais_codigo` ) REFERENCES `pais` ( `codigo` );
ALTER TABLE `cliente` ADD CONSTRAINT `fk_estado_cl` FOREIGN KEY ( `estado_codigo` ) REFERENCES `estado` ( `codigo` );

INSERT INTO cliente (email, nome, sobrenome, documento, endereco, complemento, cidade, pais_codigo, estado_codigo, telefone, cep )
VALUES ('01 email', '01 nome', '01 sobrenome', '0123456789101', '01 endereco', '01 complemento', '01 cidade',1, 1, 123456789, 12345678);

INSERT INTO cliente (email, nome, sobrenome, documento, endereco, complemento, cidade, pais_codigo, estado_codigo, telefone, cep )
VALUES ('02 email', '02 nome', '02 sobrenome', '0123456789102', '02 endereco', '02 complemento', '02 cidade',1, 1, 123456789, 12345678);
