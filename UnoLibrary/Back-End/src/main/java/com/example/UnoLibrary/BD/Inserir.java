package com.example.UnoLibrary.BD;

import com.example.UnoLibrary.User.User;

public class Inserir
{
    public String sql;
    public void salvar(User dados)
    {
        sql = "INSERT INTO clientes(id,login,nomeempresa,cnpj,razaosocial,inscricaoestadual,email,site,cep,cidade,uf,rua,bairro,numero,complemento,senha,senhaconfirmada,logotipog,logotipop) values(dados)";
    }
}
