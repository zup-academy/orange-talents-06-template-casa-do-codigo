CREATE TABLE estado(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	codigo_pais BIGINT(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `estado` ADD CONSTRAINT `fk_estado` FOREIGN KEY ( `codigo_pais` ) REFERENCES `pais` ( `codigo` );

insert into estado (nome, codigo_pais) values ('01 estado', 1);
insert into estado (nome, codigo_pais) values ('02 estado', 1);
insert into estado (nome, codigo_pais) values ('03 estado', 2);
insert into estado (nome, codigo_pais) values ('04 estado', 3)