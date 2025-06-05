select * from tb_usuario U
inner join tb_tipousuario TU on U.id_tipousuario = TU.id
inner join tb_livros L on U.id_livro = L.id
inner join tb_autor A on L.id = A.id_livro
inner join tb_tipolivros TL on L.id_tipo = TL.id
