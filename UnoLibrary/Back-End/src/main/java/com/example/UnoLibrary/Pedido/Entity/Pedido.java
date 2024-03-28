package com.example.UnoLibrary.Pedido.Entity;

import com.example.UnoLibrary.Pedido.DAL.PedidoDAL;

import java.time.LocalDate;
import java.util.List;

public class Pedido
{
    private List<ItemPedido> LI;
    private Long ped_id;
    private Long juridica_jur_id; // objeto pessoa
    private LocalDate ped_data;
    private LocalDate ped_data_entrega;

    public Pedido() {
    }

    public Pedido(Long ped_id, Long juridica_jur_id, LocalDate ped_data, LocalDate ped_data_entrega) {
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

    public LocalDate getPed_data() {
        return ped_data;
    }

    public void setPed_data(LocalDate ped_data) {
        this.ped_data = ped_data;
    }

    public LocalDate getPed_data_entrega() {
        return ped_data_entrega;
    }

    public void setPed_data_entrega(LocalDate ped_data_entrega) {
        this.ped_data_entrega = ped_data_entrega;
    }

    public boolean salvarPedido() {
        PedidoDAL pedidoDAL = new PedidoDAL();
        return pedidoDAL.gravar(this);
    }

    public Long getUltimo() {
        PedidoDAL pedidoDAL = new PedidoDAL();
        return pedidoDAL.ultimoPedido();
    }
}
