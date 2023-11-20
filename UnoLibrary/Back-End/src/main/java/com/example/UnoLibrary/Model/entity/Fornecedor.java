package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Table(name = "fornecedor")
public class Fornecedor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "for_id")
    private  long for_id;
    @Column(name = "for_nome")
    private String nome;

    public Fornecedor(long for_id, String nome) {
        this.for_id = for_id;
        this.nome = nome;
    }

    public long getFor_id() {
        return for_id;
    }

    public void setFor_id(long for_id) {
        this.for_id = for_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
