

	use dbFuncionarios;

	create table tb_Funcionario(

	nome varchar(255) primary key,

	cargo varchar(255),

	data_contratacao datetime
	);
    
ALTER TABLE tb_Funcionario
DROP PRIMARY KEY;

ALTER TABLE tb_Funcionario
ADD id INT AUTO_INCREMENT PRIMARY KEY;


	insert into tb_Funcionario (nome, cargo, data_contratacao) values ('Bruno', 'Gerente', '2023-09-21 11:11:11');

create table tb_login(
usuario varchar(255)
primary key,senha varchar(255)
);

INSERT INTO tb_login (usuario, senha) VALUES ('bruno', '123');
	select *
	from tb_Funcionario;

SELECT * FROM tb_login;

