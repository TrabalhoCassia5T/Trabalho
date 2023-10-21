package com.example.UnoLibrary.Model.Client;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "dataNasc")
    private String dataNasc;
    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client (ClientRequestDTO data)
    {
        this.nome = data.nome();
        this.sobrenome = data.sobrenome();
        this.telefone = data.telefone();
        this.cpf = data.telefone();
        this.endereco = data.endereco();
        this.cidade = data.cidade();
        this.dataNasc = data.dataNasc();
        this.email = data.email();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

