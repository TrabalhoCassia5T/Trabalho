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
    @Column(name="edit_nome")
    private String nome;
    @Column(name="edit_telefone")
    private String telefone;
    @Column(name="edit_email")
    private String email;
    @Column(name="edit_qtde_livros")
    private int quantidade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private Endereco endereco;
    @OneToMany(mappedBy = "editora")
    private List<TituloEditora> titulos;


    public Editora() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Editora(Long id, String telefone, String email, String nome, int quantidade, Endereco endereco) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
