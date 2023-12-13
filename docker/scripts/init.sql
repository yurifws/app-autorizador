drop table if exists miniautorizador.tb_cartao;

create table miniautorizador.tb_cartao 
(
	id 		bigint  		not null auto_increment, 
	numero 	bigint 			not null,
	senha 	varchar(255)	not null,
	saldo 	decimal(10, 2) 	default 500.00,
	primary key (id)
);

insert into miniautorizador.tb_cartao (numero, senha, saldo) values (1111222233334444, "1234", 1000);
insert into miniautorizador.tb_cartao (numero, senha) values (1111222233335555, "1234");