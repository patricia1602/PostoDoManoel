create database postodomanoel;

use postodomanoel;

-- Combustivel
-- criar tabela
create table combustivel (
id integer auto_increment not null,
nome varchar(50) not null, 
valor_unidade double not null,
primary key(id)
); 

-- apagar tabela
-- drop table combustivel;

select * from combustivel;

-- insere na tabela
insert into combustivel
(nome, valor_unidade)
values
('Gasolina', 2.89)
; 



-- Abastecimento

create table abastecimento (
id integer auto_increment not null,
id_combustivel integer not null,
id_frentista integer not null,
quantidade_litro double not null, 
valor_total double not null,
primary key(id)
); 

select * from abastecimento;
-- drop table abastecimento;
-- insere na tabela
insert into abastecimento
(id_combustivel, id_frentista, quantidade_litro, valor_total)
values
(1, 1, 5, 14.45)
; 

select * from abastecimento;

use postodomanoel;

select * from abastecimento;

create table frentista (
id integer auto_increment not null,
nome varchar(50) not null, 
primary key(id)
);

select * from frentista;

insert into frentista
(nome)
values
('Alex')
; 

select * from frentista;

select * from abastecimento;

select * from combustivel;