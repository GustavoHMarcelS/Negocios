create database biblioteca;
USE biblioteca; 
create table tb_TipoLivros (
id int  auto_increment PRIMARY KEY,
tipo varchar (30) NOT NULL
);

insert into tb_tipolivros (tipo)
values('Sustentabilidade'),
('Tecnologia'),
('Ciência e Sociedade');


create table tb_livros(
id int auto_increment PRIMARY KEY,
nome varchar (100) NOT NULL,
id_tipo int, 
FOREIGN KEY (id_tipo) REFERENCES tb_tipolivros(id)
);

insert into tb_livros(nome,id_tipo)
values('Código Limpo: Habilidades Práticas do Agile Software',2),
('Estrutura de Dados e Algoritmos em Java',2),
('Python para Análise de Dados',2),
('Sustentabilidade: O Que É - O Que Não é',1),
('A Quinta Disciplina: Arte e Prática da Organização que Aprende',1),
('Educação Ambiental: Princípios e Práticas',1),
('Ciência, Tecnologia e Sociedade',3),
('A Nova Aliança: Metamorfose da Ciência',3),
('O Que É Ciência?',3);

create table tb_autor(
id int auto_increment PRIMARY KEY,
nome varchar (30),
id_livro int,
FOREIGN KEY (id_livro) REFERENCES tb_livros(id)
);

insert into tb_autor(nome,id_livro)
values('Robert C. Martin',1),
('Michael T.Goodrich',2),
('Wes McKinney',3),
('Ricardo Abramovay',4),
('Peter M. Senge',5),
('Lucie Sauvé',6),
('Ildeu de Castro',7),
('Ilya Prigogine',8),
('Rubem Alves',9);

create table tb_TipoUsuario(
id int auto_increment PRIMARY KEY,
tipo varchar (20)
);
insert into tb_TipoUsuario (tipo)
values ('Administrador'),('Comum');

CREATE TABLE tb_Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    dt_nascimento DATE NOT NULL,
    id_livro INT,
    id_tipousuario INT,
    FOREIGN KEY (id_livro) REFERENCES tb_Livros(id),
    FOREIGN KEY (id_tipousuario) REFERENCES tb_TipoUsuario(id)
);

insert into tb_Usuario(nome,dt_nascimento,id_livro,id_tipousuario)
values('Arthur Trindade','1996-10-25',8,1),
	  ('Bruno Carvalho ','1987-04-03',2,2),
	  ('Raquel Brito','1994-12-15',6,2);

    

-- insert para teste 

insert into tb_Usuario(nome,dt_nascimento,id_livro,id_tipousuario)
values('macaco Trindade','2015-10-25',1,1)
	







DELIMITER $$

CREATE TRIGGER trg_verifica_maioridade
BEFORE INSERT ON tb_Usuario
FOR EACH ROW
BEGIN
    IF NEW.dt_nascimento > CURDATE() - INTERVAL 18 YEAR THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erro: o usuário deve ter pelo menos 18 anos.';
    END IF;
END$$

DELIMITER ;

