package com.example.UnoLibrary.Model.entity;


import jakarta.persistence.*;

@Entity
@Table(name="titulo_editora")
public class TituloEditora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tit_edi_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "titulo_tit_id", referencedColumnName = "tit_id")
    private Titulo titulo;
    @ManyToOne
    @JoinColumn(name = "editora_edit_id", referencedColumnName = "edit_id")
    private Editora editora;

    public TituloEditora() {
    }

    public TituloEditora(Long id) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Editora getEditora() {
        return editora;
    }
}
