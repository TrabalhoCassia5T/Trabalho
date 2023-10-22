package com.example.UnoLibrary.Model.Client;

public record ClientRequestDTO(String nome, String sobrenome, String telefone, String cpf, String endereco, String cidade,
                               String data_nasc, String email) {
}
