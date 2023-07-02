CREATE TABLE pagamento (
 id bigint NOT NULL AUTO_INCREMENT,
 nome varchar(100) DEFAULT NULL,
 descricao varchar(200) DEFAULT NULL,
 preco number DEFAULT NULL,
PRIMARY KEY (id)
);
