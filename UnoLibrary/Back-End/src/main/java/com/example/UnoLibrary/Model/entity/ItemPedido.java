package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "item_pedido")
@Entity(name = "item_pedido")
public class ItemPedido
{
    @Column(name = "pedido_ped_id")
    private long ped_id;
    @Column(name = "titulo_tit_id")
    private int pedido_tit_id;
    @Column(name = "itp_qtde")
    private int ped_qtde;

    public ItemPedido(long ped_id, int pedido_tit_id, int ped_qtde) {
        this.ped_id = ped_id;
        this.pedido_tit_id = pedido_tit_id;
        this.ped_qtde = ped_qtde;
    }

    public long getPed_id() {
        return ped_id;
    }

    public void setPed_id(long ped_id) {
        this.ped_id = ped_id;
    }

    public int getPedido_tit_id() {
        return pedido_tit_id;
    }

    public void setPedido_tit_id(int pedido_tit_id) {
        this.pedido_tit_id = pedido_tit_id;
    }

    public int getPed_qtde() {
        return ped_qtde;
    }

    public void setPed_qtde(int ped_qtde) {
        this.ped_qtde = ped_qtde;
    }
}
