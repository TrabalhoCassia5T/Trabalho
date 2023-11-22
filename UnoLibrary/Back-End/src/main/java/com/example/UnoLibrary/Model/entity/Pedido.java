package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.util.Date;
@Table(name = "pedido")
@Entity
public class Pedido
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long ped_id;
    @Column(name = "juridica_jur_id")
    private Long juridica_jur_id;
    @Column(name = "ped_data")
    private Date ped_data;
    @Column(name = "ped_data_entrega")
    private Date ped_data_entrega;
    public Pedido(){}

    public Pedido(Long ped_id, Long juridica_jur_id, Date ped_data, Date ped_data_entrega) {
        this.ped_id = ped_id;
        this.juridica_jur_id = juridica_jur_id;
        this.ped_data = ped_data;
        this.ped_data_entrega = ped_data_entrega;
    }

    public Long getPed_id() {
        return ped_id;
    }

    public void setPed_id(Long ped_id) {
        this.ped_id = ped_id;
    }

    public Long getJuridica_jur_id() {
        return juridica_jur_id;
    }

    public void setJuridica_jur_id(Long juridica_jur_id) {
        this.juridica_jur_id = juridica_jur_id;
    }

    public Date getPed_data() {
        return ped_data;
    }

    public void setPed_data(Date ped_data) {
        this.ped_data = ped_data;
    }

    public Date getPed_data_entrega() {
        return ped_data_entrega;
    }

    public void setPed_data_entrega(Date ped_data_entrega) {
        this.ped_data_entrega = ped_data_entrega;
    }
}
