package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Table(name = "item_pedido")
@Entity(name = "item_pedido")
public class ItemPedido
{
    @Id
    @Column(name = "pedido_ped_id")
    private Long ped_id;
    @Column(name = "titulo_tit_id")
    private Long pedido_tit_id;
    @Column(name = "itp_qtde")
    private int ped_qtde;

    public ItemPedido (){}

    public ItemPedido(Long ped_id, Long pedido_tit_id, int ped_qtde) {
        this.ped_id = ped_id;
        this.pedido_tit_id = pedido_tit_id;
        this.ped_qtde = ped_qtde;
    }

    public Long getPed_id() {
        return ped_id;
    }

    public void setPed_id(Long ped_id) {
        this.ped_id = ped_id;
    }

    public Long getPedido_tit_id() {
        return pedido_tit_id;
    }

    public void setPedido_tit_id(Long pedido_tit_id) {
        this.pedido_tit_id = pedido_tit_id;
    }

    public int getPed_qtde() {
        return ped_qtde;
    }

    public void setPed_qtde(int ped_qtde) {
        this.ped_qtde = ped_qtde;
    }
}
