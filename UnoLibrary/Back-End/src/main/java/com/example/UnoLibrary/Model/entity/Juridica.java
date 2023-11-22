package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "juridica")
public class Juridica {
    @Id
    @Column(name = "jur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jur_id;
    @Column(name = "jur_cnpj")
    private String jur_cnpj;
    @Column(name = "jur_razao_social")
    private String jur_razao_social;
    @Column(name="pessoa_pes_id")
    private Long pessoa_pes_id;

    public Juridica() {
    }

    public Juridica(Long jur_id, String jur_cnpj, String jur_razao_social, Long pessoa_pes_id) {
        this.jur_id = jur_id;
        this.jur_cnpj = jur_cnpj;
        this.jur_razao_social = jur_razao_social;
        this.pessoa_pes_id = pessoa_pes_id;
    }

    public Long getJur_id() {
        return jur_id;
    }

    public void setJur_id(Long jur_id) {
        this.jur_id = jur_id;
    }

    public String getJur_cnpj() {
        return jur_cnpj;
    }

    public void setJur_cnpj(String jur_cnpj) {
        this.jur_cnpj = jur_cnpj;
    }

    public String getJur_razao_social() {
        return jur_razao_social;
    }

    public void setJur_razao_social(String jur_razao_social) {
        this.jur_razao_social = jur_razao_social;
    }

    public Long getPessoa_pes_id() {
        return pessoa_pes_id;
    }

    public void setPessoa_pes_id(Long pessoa_pes_id) {
        this.pessoa_pes_id = pessoa_pes_id;
    }
}
