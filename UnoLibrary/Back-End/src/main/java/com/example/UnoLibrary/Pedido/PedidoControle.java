package com.example.UnoLibrary.Pedido;

import com.example.UnoLibrary.Pedido.Titulo;

import java.util.List;

public class PedidoControle {
    public boolean verificaLivro(String nome,int edicao){
        Titulo titulo = new Titulo();
        List<Titulo> tit = titulo.buscaTitulo(nome);
        //singleton

        if (tit.size() > 0){
            for (Titulo t: tit){
                if (t.getEdicao() == edicao) {
                    return true;
                }
            }
            return  false;
        }
        else{
            return false;
        }
    }


}
