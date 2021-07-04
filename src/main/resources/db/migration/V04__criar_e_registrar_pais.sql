CREATE TABLE pais(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into pais (nome) values ("01 país");
insert into pais (nome) values ("02 país");
insert into pais (nome) values ("03 país");
insert into pais (nome) values ("04 país");

