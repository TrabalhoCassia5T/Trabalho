INSERT INTO Autor ("aut_nome", "aut_nacionalidade", "aut_desc")
VALUES ('Nome do Autor', 'Nacionalidade do Autor', 'Descrição do Autor');
INSERT INTO Autor ("aut_nome", "aut_nacionalidade", "aut_desc")
VALUES ('John Doe', 'Americano', 'Autor de ficção científica');


INSERT INTO Endereco ("end_rua", "end_numero", "end_bairro", "end_cep", "end_cidade", "end_uf")
VALUES ('Rua Principal', '123', 'Bairro Central', '12345-678', 'Cidade A', 'UF');
INSERT INTO Editora ("end_id", "edit_nome", "edit_telefone", "edit_email", "edit_qtde_livros")
VALUES (
  (SELECT "end_id" FROM Endereco WHERE "end_rua" = 'Rua Principal' AND "end_numero" = '123'),
  'Nome da Editora',
  '123456789',
  'editora@email.com',
  100
);
INSERT INTO Endereco ("end_rua", "end_numero", "end_bairro", "end_cep", "end_cidade", "end_uf")
VALUES ('Avenida Central', '456', 'Bairro Novo', '54321-987', 'Cidade B', 'UF');
INSERT INTO Editora ("end_id", "edit_nome", "edit_telefone", "edit_email", "edit_qtde_livros")
VALUES (
  (SELECT "end_id" FROM Endereco WHERE "end_rua" = 'Avenida Central' AND "end_numero" = '456'),
  'Editora XYZ',
  '987654321',
  'editora_xyz@email.com',
  150
);


INSERT INTO Titulo ("tit_nome", "tit_qtde", "tit_edicao", "tit_genero")
VALUES ('Livro A', 100, 1, 'Ficção');
INSERT INTO Titulo ("tit_nome", "tit_qtde", "tit_edicao", "tit_genero")
VALUES ('Livro B', 150, 2, 'Fantasia');
INSERT INTO Titulo ("tit_nome", "tit_qtde", "tit_edicao", "tit_genero")
VALUES ('Livro C', 120, 1, 'Mistério');
