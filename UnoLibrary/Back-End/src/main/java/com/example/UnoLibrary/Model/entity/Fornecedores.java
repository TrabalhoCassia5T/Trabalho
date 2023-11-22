package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
public class Fornecedores
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "for_id")
    private  long for_id;
    @Column(name = "for_data")
    private Date for_data;
    @Column(name = "juridica_jur_id")
    private Long juridica_jur_id;

    public Fornecedores() {
    }

    public Fornecedores(long for_id, Date for_data, Long juridica_jur_id) {
        this.for_id = for_id;
        this.for_data = for_data;
        this.juridica_jur_id = juridica_jur_id;
    }

    public long getFor_id() {
        return for_id;
    }

    public void setFor_id(long for_id) {
        this.for_id = for_id;
    }

    public Date getFor_data() {
        return for_data;
    }

    public void setFor_data(Date for_data) {
        this.for_data = for_data;
    }

    public Long getJuridica_jur_id() {
        return juridica_jur_id;
    }

    public void setJuridica_jur_id(Long juridica_jur_id) {
        this.juridica_jur_id = juridica_jur_id;
    }
}
