create database alexandria1;
use alexandria1;

use db_sustecl;
create table usuario(
	id int auto_increment primary key,
    nome varchar(50),
    senha varchar(30),
    dataNasc date,
    id_livro INT,
    FOREIGN KEY (id_livro) REFERENCES tb_Livros(id)
);
create table admin(
	id int primary key auto_increment,
    nome varchar(50),
    email varchar(100),
    senha varchar(30)
);

create table tb_TipoLivros (
id int  auto_increment PRIMARY KEY,
tipo varchar (30) NOT NULL
);

create table tb_livros(
id int auto_increment PRIMARY KEY,
nome varchar (100) NOT NULL,
id_tipo int, 
autor varchar(100),
FOREIGN KEY (id_tipo) REFERENCES tb_tipolivros(id)
);


