package com.example.UnoLibrary.Pedido.Controle;

import com.example.UnoLibrary.Pedido.Entity.ItemPedido;
import com.example.UnoLibrary.Pedido.Entity.Pedido;
import com.example.UnoLibrary.Pedido.Entity.Titulo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class PedidoControle {
    public static LocalDate generateDateAfterSevenDays() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusDays(7); // Adiciona 7 dias à data atual
    }
    public boolean salvarTitulo(String nome, int edicao, int quantidade) {
        TituloControle tituloControle = new TituloControle();
        Titulo titi = tituloControle.buscaTitulo(nome, edicao);
        Pedido pedido = new Pedido(0L,1L,LocalDate.now(),generateDateAfterSevenDays());
        ItemPedido itemPedido;
        if(titi!=null){
            itemPedido = new ItemPedido(titi.getId(),quantidade);
            if(pedido.salvarPedido()){
                itemPedido.setPed_id(pedido.getUltimo());
                if(itemPedido.salvarItemPedido()){
                    return true;
                }
                else{
                    return  false;
                }
            }
            else{
                return  false;
            }
        }
        else {
            return false;
        }
    }
}
