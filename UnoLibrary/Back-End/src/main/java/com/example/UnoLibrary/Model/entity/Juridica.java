package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Juridica")
public class Juridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jur_id")
    private Long id;

    @Column(name = "jur_cnpj")
    private String cnpj;

    @Column(name = "jur_razao_social")
    private String razaoSocial;

    @OneToOne
    @JoinColumn(name = "pessoa_pes_id")
    private Pessoa pessoa;

    public Juridica() {
    }

    public Juridica(Long id, String cnpj, String razaoSocial, Pessoa pessoa) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
