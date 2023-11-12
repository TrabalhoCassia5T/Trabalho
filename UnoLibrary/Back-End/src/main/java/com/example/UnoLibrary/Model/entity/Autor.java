package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor implements Serializable {
    @Id
    @Column(name="aut_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name="aut_nome")
    private String nome;
    @Column(name="aut_nacionalidade")
    private String nacionalidade;
    @Column(name="aut_desc")
    private String desc;
    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Titulo> titulo;


    public Autor() {
    }

    public Autor(Long id, String nome, String nacionalidade, String desc) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
