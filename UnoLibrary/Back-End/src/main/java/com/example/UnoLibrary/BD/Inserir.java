package com.example.UnoLibrary.BD;

import com.example.UnoLibrary.Client.Client;
import com.example.UnoLibrary.User.User;

public class Inserir
{
    public String sql;
    public void salvar(User dados)
    {
        sql = "INSERT INTO empresas(id,login,nomeempresa,cnpj,razaosocial,inscricaoestadual,email,site,cep,cidade,uf,rua,bairro,numero,complemento,senha,senhaconfirmada,logotipog,logotipop) values(dados)";
    }

    public void inserirCliente(Client dados) {
        sql = "INSERT INTO clientes(id, nome, sobrenome, telefone, cpf, endereco, cidade, dataNasc, email) value (dados)";
    }
}
