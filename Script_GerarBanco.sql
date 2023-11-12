CREATE TABLE IF NOT EXISTS Endereco (
	"end_id" SERIAL PRIMARY KEY,
	"end_rua" VARCHAR(45) NOT NULL,
	"end_numero" VARCHAR(45) NOT NULL,
	"end_bairro" VARCHAR(45) NOT NULL,
	"end_cep" VARCHAR(45) NOT NULL,
	"end_cidade" VARCHAR(45) NOT NULL,
	"end_uf" VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Pessoa (
  "pes_id" SERIAL PRIMARY KEY,
  "end_id" INT NOT NULL,
  "pes_nome" VARCHAR(45) NOT NULL,
  "pes_telefone" VARCHAR(45) NOT NULL,
  "pes_email" VARCHAR(45) NOT NULL,
  "pes_url" VARCHAR(45) NOT NULL,
  FOREIGN KEY ("end_id") REFERENCES Endereco ("end_id")
);

CREATE TABLE IF NOT EXISTS Fisica (
  "fis_id" SERIAL PRIMARY KEY,
  "fis_cpf" VARCHAR(45) NOT NULL,
  "fis_data_nasc" DATE NOT NULL,
  "fis_est_civil" VARCHAR(45) NOT NULL,
  "fis_sexo" VARCHAR(45) NOT NULL,
  "pessoa_pes_id" INT NOT NULL,
  FOREIGN KEY ("pessoa_pes_id") REFERENCES Pessoa ("pes_id")
);

CREATE TABLE IF NOT EXISTS Juridica (
  "jur_id" SERIAL PRIMARY KEY,
  "jur_cnpj" VARCHAR(45) NOT NULL,
  "jur_razao_social" VARCHAR(45) NOT NULL,
  "pessoa_pes_id" INT NOT NULL,
  FOREIGN KEY ("pessoa_pes_id") REFERENCES Pessoa ("pes_id")
);

CREATE TABLE IF NOT EXISTS Cliente (
  "cli_id" SERIAL PRIMARY KEY,
  "cli_data" DATE NOT NULL,
  "fisica_fis_id" INT,
  FOREIGN KEY ("fisica_fis_id") REFERENCES Fisica ("fis_id")
);

CREATE TABLE IF NOT EXISTS Funcionario (
  "func_id" SERIAL PRIMARY KEY,
  "func_cargo" VARCHAR(45) NOT NULL,
  "fisica_fis_id" INT NOT NULL,
  FOREIGN KEY ("fisica_fis_id") REFERENCES Fisica ("fis_id")
);

CREATE TABLE IF NOT EXISTS Titulo (
  "tit_id" SERIAL PRIMARY KEY,
  "tit_nome" VARCHAR(45) NOT NULL,
  "tit_qtde" INT NOT NULL,
  "tit_edicao" INT NOT NULL,
  "tit_genero" VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Autor (
  "aut_id" SERIAL PRIMARY KEY,
  "aut_nome" VARCHAR(45) NOT NULL,
  "aut_nacionalidade" VARCHAR(45) NOT NULL,
  "aut_desc" VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Editora (
  "edit_id" SERIAL PRIMARY KEY,
	"end_id" INT NOT NULL,
	"edit_nome" VARCHAR(45) NOT NULL,
  "edit_telefone" VARCHAR(45) NOT NULL,
  "edit_email" VARCHAR(45) NOT NULL,
  "edit_qtde_livros" INT NOT NULL,
	FOREIGN KEY ("end_id") REFERENCES Endereco ("end_id")
);

CREATE TABLE IF NOT EXISTS Titulo_Autor (
  "tit_aut_id" SERIAL PRIMARY KEY,
  "titulo_tit_id" INT NOT NULL,
  "autor_aut_id" INT NOT NULL,
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id"),
  FOREIGN KEY ("autor_aut_id") REFERENCES Autor ("aut_id")
);

CREATE TABLE IF NOT EXISTS Titulo_Editora (
  "tit_edi_id" SERIAL PRIMARY KEY,
  "titulo_tit_id" INT NOT NULL,
  "editora_edit_id" INT NOT NULL,
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id"),
  FOREIGN KEY ("editora_edit_id") REFERENCES Editora ("edit_id")
);

CREATE TABLE IF NOT EXISTS Exemplar (
  "exe_id" SERIAL PRIMARY KEY,
  "exe_status" VARCHAR(45) NOT NULL,
  "exe_data_entrada" DATE NOT NULL,
  "titulo_tit_id" INT NOT NULL,
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id")
);

CREATE TABLE IF NOT EXISTS Usuario (
  "funcionario_func_id" INT NOT NULL,
  "usu_login" VARCHAR(45) NOT NULL,
  "usu_senha" VARCHAR(45) NOT NULL,
  "usu_data_perm" VARCHAR(45) NOT NULL,
  "usu_data_desativa" VARCHAR(45) NOT NULL,
  "usu_nivel" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("funcionario_func_id"),
  FOREIGN KEY ("funcionario_func_id") REFERENCES Funcionario ("func_id")
);

CREATE TABLE IF NOT EXISTS Emprestimo (
  "emp_id" SERIAL PRIMARY KEY,
  "cliente_cli_id" INT NOT NULL,
  "emp_data" DATE NOT NULL,
  "emp_prev_devolucao" DATE NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  "emp_status" VARCHAR(45) NOT NULL,
  FOREIGN KEY ("cliente_cli_id") REFERENCES Cliente ("cli_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Emprestimo_Exemplar (
  "emprestimo_emp_id" INT NOT NULL,
  "exemplar_exe_id" INT NOT NULL,
  "emp_data_dvlv" DATE NOT NULL,
  PRIMARY KEY ("emprestimo_emp_id", "exemplar_exe_id"),
  FOREIGN KEY ("emprestimo_emp_id") REFERENCES Emprestimo ("emp_id"),
  FOREIGN KEY ("exemplar_exe_id") REFERENCES Exemplar ("exe_id")
);

CREATE TABLE IF NOT EXISTS Recebimento (
  "rec_id" SERIAL PRIMARY KEY,
  "rec_valor" DOUBLE PRECISION NOT NULL,
  "rec_data" DATE NOT NULL,
  "emprestimo_emp_id" INT NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("emprestimo_emp_id") REFERENCES Emprestimo ("emp_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Renovacao (
  "ren_id" SERIAL PRIMARY KEY,
  "emprestimo_exemplar_emprestimo_emp_id" INT NOT NULL,
  "emprestimo_exemplar_exemplar_exe_id" INT NOT NULL,
  "ren_data_prev_devolucao" DATE NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("emprestimo_exemplar_emprestimo_emp_id", "emprestimo_exemplar_exemplar_exe_id") REFERENCES Emprestimo_Exemplar ("emprestimo_emp_id", "exemplar_exe_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Baixa (
  "baix_id" SERIAL PRIMARY KEY,
  "baix_motivo" VARCHAR(45) NOT NULL,
  "baix_desc" VARCHAR(45) NOT NULL,
  "baix_data" VARCHAR(45) NOT NULL,
  "exemplar_exe_id" INT NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("exemplar_exe_id") REFERENCES Exemplar ("exe_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Selecao (
  "sel_id" SERIAL PRIMARY KEY,
  "cliente_cli_id" INT NOT NULL,
  "titulo_tit_id" INT NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("cliente_cli_id") REFERENCES Cliente ("cli_id"),
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Reserva (
  "res_id" SERIAL PRIMARY KEY,
  "titulo_tit_id" INT NOT NULL,
  "cliente_cli_id" INT NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id"),
  FOREIGN KEY ("cliente_cli_id") REFERENCES Cliente ("cli_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS SolicitarTitulo (
  "stit_id" SERIAL PRIMARY KEY,
  "funcionario_func_id" INT NOT NULL,
  "stit_data" VARCHAR(45) NOT NULL,
  "stit_obs" VARCHAR(45) NOT NULL,
  FOREIGN KEY ("funcionario_func_id") REFERENCES Funcionario ("func_id")
);

CREATE TABLE IF NOT EXISTS Item_Solicitacao (
  "its_id" INT NOT NULL,
  "solicitar_titulo_stit_id" INT NOT NULL,
  "titulo_tit_id" INT NOT NULL,
  "its_quantidade" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("its_id", "solicitar_titulo_stit_id", "titulo_tit_id"),
  FOREIGN KEY ("solicitar_titulo_stit_id") REFERENCES SolicitarTitulo ("stit_id"),
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id")
);

CREATE TABLE IF NOT EXISTS Pedido (
  "ped_id" SERIAL PRIMARY KEY,
  "juridica_jur_id" INT NOT NULL,
  "ped_data" DATE NOT NULL,
  "ped_data_entrega" VARCHAR(45) NOT NULL,
  FOREIGN KEY ("juridica_jur_id") REFERENCES Juridica ("jur_id")
);

CREATE TABLE IF NOT EXISTS Comprar (
  "comp_id" SERIAL PRIMARY KEY,
  "pedido_ped_id" INT NOT NULL,
  "comp_data" DATE NOT NULL,
  "comp_nota" VARCHAR(45) NOT NULL,
  "comp_valor_tot" DOUBLE PRECISION NOT NULL,
  "comp_forma_pagamento" VARCHAR(45) NOT NULL,
  "usuario_funcionario_func_id" INT NOT NULL,
  FOREIGN KEY ("pedido_ped_id") REFERENCES Pedido ("ped_id"),
  FOREIGN KEY ("usuario_funcionario_func_id") REFERENCES Usuario ("funcionario_func_id")
);

CREATE TABLE IF NOT EXISTS Item_Pedido (
  "pedido_ped_id" INT NOT NULL,
  "titulo_tit_id" INT NOT NULL,
  "itp_qtde" INT NULL,
  PRIMARY KEY ("pedido_ped_id", "titulo_tit_id"),
  FOREIGN KEY ("pedido_ped_id") REFERENCES Pedido ("ped_id"),
  FOREIGN KEY ("titulo_tit_id") REFERENCES Titulo ("tit_id")
);

CREATE TABLE IF NOT EXISTS Item_Compra (
  "entrada_pedidos_entped_id" INT NOT NULL,
  "item_pedido_pedido_ped_id" INT NOT NULL,
  "item_pedido_titulo_tit_id" INT NOT NULL,
  "itc_qtde" VARCHAR(45) NOT NULL,
  "itc_valor" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("entrada_pedidos_entped_id", "item_pedido_pedido_ped_id", "item_pedido_titulo_tit_id"),
  FOREIGN KEY ("entrada_pedidos_entped_id") REFERENCES Comprar ("comp_id"),
  FOREIGN KEY ("item_pedido_pedido_ped_id", "item_pedido_titulo_tit_id") REFERENCES Item_Pedido ("pedido_ped_id", "titulo_tit_id")
);

CREATE TABLE IF NOT EXISTS Encomenda_Titulo (
  "pedido_ped_id" INT NOT NULL,
  "solicitar_titulo_stit_id" INT NOT NULL,
  PRIMARY KEY ("pedido_ped_id", "solicitar_titulo_stit_id"),
  FOREIGN KEY ("pedido_ped_id") REFERENCES Pedido ("ped_id"),
  FOREIGN KEY ("solicitar_titulo_stit_id") REFERENCES SolicitarTitulo ("stit_id")
);

CREATE TABLE IF NOT EXISTS Parametrizacao (
	"pam_id" SERIAL PRIMARY KEY,
	"end_id" INT NOT NULL,
	"pam_nome_fantasia" VARCHAR(45) NOT NULL,
  	"pam_razao_social" VARCHAR(45) NOT NULL,
	"pam_site" VARCHAR(45) NOT NULL,
	"pam_email" VARCHAR(45) NOT NULL,
	"pam_cnpj" VARCHAR(45) NOT NULL,
	"pam_insc_estadual" VARCHAR(45) NOT NULL,
	"pam_logotipo_grande" VARCHAR(45) NOT NULL,
	"pam_logotipo_peq" VARCHAR(45) NOT NULL,
	"pam_login" VARCHAR(45) NOT NULL,
	"pam_senha" VARCHAR(45) NOT NULL,
	FOREIGN KEY ("end_id") REFERENCES Endereco ("end_id")
);


-------------------------- Só para caso queiramos reiniciar o banco ---------------------------------
/*
DROP TABLE IF EXISTS Fisica CASCADE;
DROP TABLE IF EXISTS autor CASCADE;
DROP TABLE IF EXISTS editora CASCADE;
DROP TABLE IF EXISTS pessoa CASCADE;
DROP TABLE IF EXISTS titulo CASCADE;
DROP TABLE IF EXISTS Juridica CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Funcionario CASCADE;
DROP TABLE IF EXISTS Contato CASCADE;
DROP TABLE IF EXISTS Titulo_Autor CASCADE;
DROP TABLE IF EXISTS Titulo_Editora CASCADE;
DROP TABLE IF EXISTS Exemplar CASCADE;
DROP TABLE IF EXISTS Usuario CASCADE;
DROP TABLE IF EXISTS Emprestimo CASCADE;
DROP TABLE IF EXISTS Emprestimo_Exemplar CASCADE;
DROP TABLE IF EXISTS Recebimento CASCADE;
DROP TABLE IF EXISTS Renovação CASCADE;
DROP TABLE IF EXISTS Baixa CASCADE;
DROP TABLE IF EXISTS Selecao CASCADE;
DROP TABLE IF EXISTS Reserva CASCADE;
DROP TABLE IF EXISTS SolicitarTitulo CASCADE;
DROP TABLE IF EXISTS Item_Solicitacao CASCADE;
DROP TABLE IF EXISTS Pedido CASCADE;
DROP TABLE IF EXISTS Comprar CASCADE;
DROP TABLE IF EXISTS Item_Pedido CASCADE;
DROP TABLE IF EXISTS Item_Compra CASCADE;
DROP TABLE IF EXISTS Encomenda_Titulo CASCADE;
DROP TABLE IF EXISTS Parametrizacao CASCADE;
DROP TABLE IF EXISTS Endereco CASCADE;
*/
