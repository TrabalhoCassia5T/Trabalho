package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @Column(name = "pes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pes_id;
//    @ManyToOne
//    @JoinColumn(name="end_id", nullable=false)
    @Column(name = "end_id")
    private Long end_id;
    @Column(name = "pes_nome")
    private String pes_nome;
    @Column(name = "pes_telefone")
    private String pes_telefone;
    @Column(name = "pes_email")
    private String pes_email;
    @Column(name = "pes_url")
    private String pes_url;

    public Pessoa() {
    }

    public Pessoa(Long pes_id, Long end_id, String pes_nome, String pes_telefone, String pes_email, String pes_url) {
        this.pes_id = pes_id;
        this.end_id = end_id;
        this.pes_nome = pes_nome;
        this.pes_telefone = pes_telefone;
        this.pes_email = pes_email;
        this.pes_url = pes_url;
    }

    public Long getPes_id() {
        return pes_id;
    }

    public void setPes_id(Long pes_id) {
        this.pes_id = pes_id;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_telefone() {
        return pes_telefone;
    }

    public void setPes_telefone(String pes_telefone) {
        this.pes_telefone = pes_telefone;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public String getPes_url() {
        return pes_url;
    }

    public void setPes_url(String pes_url) {
        this.pes_url = pes_url;
    }

    public Long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(Long end_id) {
        this.end_id = end_id;
    }
}

