package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="titulo_autor")
public class TituloAutor {
    @ManyToOne
    @JoinColumn(name = "Titulo_aut_id", referencedColumnName = "aut_id")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "Titulo_tit_id", referencedColumnName = "tit_id")
    private Titulo titulo;

    public TituloAutor() {
        this.autor = autor;
        this.titulo = titulo;
    }

    public Autor getAutor(){
        return autor;
    }

}
