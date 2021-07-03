CREATE TABLE livro(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(50) NOT NULL,
	resumo VARCHAR(500) NOT NULL,
	sumario text,
	preco decimal(10,2),
    pagina int(10),
    isbn text,
    entrada datetime,
    categoria_codigo BIGINT(20),
	autor_codigo BIGINT(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `livro` ADD CONSTRAINT `fk_categoria` FOREIGN KEY ( `categoria_codigo` ) REFERENCES `categoria` ( `codigo` );
ALTER TABLE `livro` ADD CONSTRAINT `fk_autor` FOREIGN KEY ( `autor_codigo` ) REFERENCES `autor` ( `codigo` );


INSERT INTO livro (titulo, resumo, sumario, preco, pagina, isbn, entrada, categoria_codigo, autor_codigo)
VALUES ('01 titulo', '01 resumo', '01 sumario', 25.03, 30, 'askies25', '2020-03-02', 1, 1);

INSERT INTO livro (titulo, resumo, sumario, preco, pagina, isbn, entrada, categoria_codigo, autor_codigo)
VALUES ('02 titulo', '02 resumo', '02 sumario', 23.03, 130, 'aski3235', '2020-03-02', 2, 1);

INSERT INTO livro (titulo, resumo, sumario, preco, pagina, isbn, entrada, categoria_codigo, autor_codigo)
VALUES ('03 titulo', '03 resumo', '03 sumario', 25.06, 30, 'askies2555', '2020-03-02', 1, 3);