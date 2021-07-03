CREATE TABLE autor(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	descricao VARCHAR(400) NOT NULL,
	instante DateTime
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into autor(nome, email, descricao, instante) 
values ('01 nome', '01email@zup.com.br', '01 descricao', '2019-01-20');
insert into autor(nome, email, descricao, instante) 
values ('02 nome', '02email@zup.com.br', '02 descricao', '2019-01-22');
insert into autor(nome, email, descricao, instante) 
values ('03 nome', '03email@zup.com.br', '03 descricao', '2019-05-24 10:00:01');