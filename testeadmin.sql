use db_sustecl;
create table usuario(
	id int auto_increment primary key,
    nome varchar(50),
    senha varchar(30),
    dataNasc date
);
create table admin(
	id int primary key auto_increment,
    nome varchar(50),
    email varchar(100),
    senha varchar(30)
);
select * from admin;
select * from usuario;

