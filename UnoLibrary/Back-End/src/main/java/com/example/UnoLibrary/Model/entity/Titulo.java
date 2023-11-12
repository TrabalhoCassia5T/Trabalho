package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="titulo")
public class Titulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tit_id")
    private Long id;
    @Column(name="tit_nome")
    private String nome;
    @Column(name="tit_qtde")
    private int qtde;
    @Column(name="tit_edicao")
    private int edicao;
    @Column(name="tit_genero")
    private String genero;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "titulo_autor", joinColumns =  @JoinColumn(name = "tit_id"), inverseJoinColumns = @JoinColumn(name = "aut_id"))
    private List<Autor> autores;
    @OneToMany(mappedBy = "titulo")
    private List<TituloEditora> Editoras;

    @OneToMany(mappedBy = "titulo")
    private List<Exemplar> exemplares;

    public Titulo() {
    }

    public Titulo(Long id, String nome, int qtde, int edicao, String genero) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
        this.edicao = edicao;
        this.genero = genero;
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

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<TituloAutor> autores) {
        autores = autores;
    }

    public List<TituloEditora> getEditoras() {
        return Editoras;
    }

    public void setEditoras(List<TituloEditora> editoras) {
        Editoras = editoras;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
}
