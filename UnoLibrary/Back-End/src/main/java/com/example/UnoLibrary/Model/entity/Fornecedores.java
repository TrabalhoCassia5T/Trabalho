package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@Getter
@EqualsAndHashCode(of = "for_id")
public class Fornecedores
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "for_id")
    private  long for_id;
    @Column(name = "for_nome")
    private String nome;

    public Fornecedores(){}
    public Fornecedores(long for_id, String nome) {
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
