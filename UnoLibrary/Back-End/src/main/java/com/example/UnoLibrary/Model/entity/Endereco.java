package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @Column(name = "end_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long end_id;
    @Column(name = "end_rua")
    private String end_rua;
    @Column(name = "end_numero")
    private String end_numero;
    @Column(name = "end_bairro")
    private String end_bairro;
    @Column(name = "end_cep")
    private String end_cep;
    @Column(name = "end_cidade")
    private String end_cidade;
    @Column(name = "end_uf")
    private String end_uf;

    @OneToOne(mappedBy = "endereco")
    private Editora editora;

    public Endereco() {
    }

    public Endereco(Long end_id, String end_rua, String end_numero, String end_bairro, String end_cep, String end_cidade, String end_uf) {
        this.end_id = end_id;
        this.end_rua = end_rua;
        this.end_numero = end_numero;
        this.end_bairro = end_bairro;
        this.end_cep = end_cep;
        this.end_cidade = end_cidade;
        this.end_uf = end_uf;
    }

    public Long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(Long end_id) {
        this.end_id = end_id;
    }

    public String getEnd_rua() {
        return end_rua;
    }

    public void setEnd_rua(String end_rua) {
        this.end_rua = end_rua;
    }

    public String getEnd_numero() {
        return end_numero;
    }

    public void setEnd_numero(String end_numero) {
        this.end_numero = end_numero;
    }

    public String getEnd_bairro() {
        return end_bairro;
    }

    public void setEnd_bairro(String end_bairro) {
        this.end_bairro = end_bairro;
    }

    public String getEnd_cep() {
        return end_cep;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }

    public String getEnd_cidade() {
        return end_cidade;
    }

    public void setEnd_cidade(String end_cidade) {
        this.end_cidade = end_cidade;
    }

    public String getEnd_uf() {
        return end_uf;
    }

    public void setEnd_uf(String end_uf) {
        this.end_uf = end_uf;
    }
}
