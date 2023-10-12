package com.example.UnoLibrary.BD;

import com.example.UnoLibrary.Client.Client;

public class Alterar {
    String sql;
    public String alterarCliente(Client dados) {
        sql = "update clientes set nome = '$1', sobrenome = '$2', telefone = '$3', endereco = '$4', cidade = '$5', dataNasc = '$6', email = '$7'";
        sql=sql.replace("$1",dados.getNome());
        sql=sql.replace("$2",dados.getSobrenome());
        sql=sql.replace("$3", dados.getTelefone());
        sql=sql.replace("$4",dados.getEndereco());
        sql=sql.replace("$5",dados.getCidade());
        sql=sql.replace("$6", dados.getDataNasc());
        sql=sql.replace("$7", dados.getEmail());

        return sql;
    }
}
