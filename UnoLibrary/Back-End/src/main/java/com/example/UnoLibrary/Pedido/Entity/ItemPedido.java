package com.example.UnoLibrary.Pedido.Entity;

import com.example.UnoLibrary.Pedido.DAL.ItemPedidoDAL;

public class ItemPedido
{
    private Long ped_id; // private Pedido ped;
    private Long pedido_tit_id; // private Titulo tit;
    private int ped_qtde;
    public ItemPedido(Long tit_id, int quantidade) {
        this.pedido_tit_id = tit_id;
        this.ped_qtde = quantidade;
    }
    public ItemPedido() {
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
    public boolean salvarItemPedido() {
        ItemPedidoDAL itemPedidoDAL = new ItemPedidoDAL();
        return itemPedidoDAL.gravar(this);
    }
}
