package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="editora")
public class Editora {
    @Id
    @Column(name="edit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="edit_telefone")
    private String telefone;
    @Column(name="edit_email")
    private String email;
    @Column(name="edit_qtdeLivros")
    private int quantidade;
    @Column(name="edit_end")
    private String endereco;
    @OneToMany(mappedBy = "editora")
    private List<TituloEditora> emprestados;


    public Editora() {
    }

    public Editora(Long id, String telefone, String email, int quantidade, String endereco) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.quantidade = quantidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
