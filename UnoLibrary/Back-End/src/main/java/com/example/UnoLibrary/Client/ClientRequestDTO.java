package com.example.UnoLibrary.Client;

public record ClientRequestDTO(String nome, String sobrenome, String telefone, String cpf, String endereco, String cidade,
                               String dataNasc, String email) {
}
