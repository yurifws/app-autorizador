create database if not exists miniautorizador;

drop table if exists miniautorizador.tb_cartao;

create table miniautorizador.tb_cartao 
(
	numero 	bigint 			not null,
	senha 	varchar(255)	not null,
	saldo 	decimal(10, 2) 	default 500.00,
	primary key (numero)
);

create database if not exists miniautorizador_test;

drop table if exists miniautorizador_test.tb_cartao;

create table miniautorizador_test.tb_cartao 
(
	numero 	bigint 			not null,
	senha 	varchar(255)	not null,
	saldo 	decimal(10, 2) 	default 500.00,
	primary key (numero)
);