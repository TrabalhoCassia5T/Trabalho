package com.example.UnoLibrary.Model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="titulo_editora")
public class TituloEditora {
    @ManyToOne
    @JoinColumn(name = "Titulo_tit_id", referencedColumnName = "tit_id")
    private Titulo titulo;
    @ManyToOne
    @JoinColumn(name = "Editora_edit_id", referencedColumnName = "edit_id")
    private Editora editora;
    public TituloEditora() {
        this.titulo = titulo;
        this.editora = editora;
    }

    public Editora getEditora() {
        return editora;
    }
}
