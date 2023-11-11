package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="titulo_autor")
public class TituloAutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tit_aut_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Titulo_aut_id", referencedColumnName = "aut_id")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "Titulo_tit_id", referencedColumnName = "tit_id")
    private Titulo titulo;

    public TituloAutor() {
    }

    public TituloAutor(Long id) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor(){
        return autor;
    }

}
