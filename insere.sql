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

INSERT INTO Titulo_Autor ("tit_id", "aut_id") VALUES (1, 1), (2, 1),(3, 2),(3, 1);

INSERT INTO Titulo_Editora ("titulo_tit_id", "editora_edit_id") VALUES (1,1), (2,1 ),(3, 1);

INSERT INTO Exemplar ("exe_status", "exe_data_entrada", "titulo_tit_id") VALUES
  ('Disponível', '2023-11-19', 1), 
  ('Emprestado', '2023-11-18', 2),
  ('Em manutenção', '2023-11-17', 3);

INSERT INTO Pessoa ("end_id", "pes_nome", "pes_telefone", "pes_email", "pes_url") VALUES
  (1, 'João Silva', '123-456-7890', 'joao@example.com', 'http://joao.com'), -- Substitua pelos valores desejados
  (2, 'Maria Oliveira', '987-654-3210', 'maria@example.com', 'http://maria.com'),
  (1, 'Carlos Santos', '555-123-4567', 'carlos@example.com', 'http://carlos.com');

INSERT INTO Fisica ("fis_cpf", "fis_data_nasc", "fis_est_civil", "fis_sexo", "pessoa_pes_id") VALUES
  ('123.456.789-01', '1990-05-15', 'Solteiro(a)', 'M', 1), -- Substitua pelos valores desejados
  ('987.654.321-02', '1985-02-28', 'Casado(a)', 'F', 2),
  ('555.123.456-03', '1988-11-10', 'Divorciado(a)', 'M', 3);

  INSERT INTO Funcionario ("func_cargo", "fisica_fis_id") VALUES
  ('Analista de Sistemas', 1), -- Substitua pelos valores desejados
  ('Gerente de Vendas', 2),
  ('Assistente Administrativo', 3);
INSERT INTO Usuario ("funcionario_func_id", "usu_login", "usu_senha", "usu_data_perm", "usu_data_desativa", "usu_nivel") VALUES
  (1, 'joao123', 'senha123', '2023-11-19', NULL, 'Administrador'), -- Substitua pelos valores desejados
  (2, 'maria456', 'senha456', '2023-11-18', '2023-12-01', 'Usuário'),
  (3, 'carlos789', 'senha789', '2023-11-17', NULL, 'Usuário');


INSERT INTO Baixa ("baix_motivo", "baix_desc", "baix_data", "exemplar_exe_id", "usuario_funcionario_func_id") VALUES
  ('Perda', 'Exemplar perdido pelo usuário.', '2023-11-19', 1, 1), -- Substitua pelos valores desejados
  ('Danificação', 'Exemplar danificado durante o empréstimo.', '2023-11-18', 2, 2),
  ('Furto', 'Exemplar furtado da biblioteca.', '2023-11-17', 3, 3);
