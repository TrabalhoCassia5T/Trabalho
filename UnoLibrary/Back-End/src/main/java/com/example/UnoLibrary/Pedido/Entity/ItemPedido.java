package com.example.UnoLibrary.Pedido.Entity;

import com.example.UnoLibrary.Pedido.DAL.ItemPedidoDAL;

public class ItemPedido
{
    private Pedido pedido; // private Pedido ped;
    private Titulo titulo;
    private int ped_qtde;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Titulo titulo, int ped_qtde) {
        this.pedido = pedido;
        this.titulo = titulo;
        this.ped_qtde = ped_qtde;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
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
