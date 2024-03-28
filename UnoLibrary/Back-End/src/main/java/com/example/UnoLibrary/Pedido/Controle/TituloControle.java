package com.example.UnoLibrary.Pedido.Controle;

import com.example.UnoLibrary.Pedido.Conexao;
import com.example.UnoLibrary.Pedido.Entity.Titulo;

import java.util.List;

public class TituloControle {

    public Titulo buscaTitulo(String nome, int edicao) {
        Conexao conexao;
        conexao = Conexao.getInstance();
        Titulo titulo = new Titulo();
        List<Titulo> tit = titulo.buscaTitulo(nome,edicao,conexao);
        if(tit.size() > 0){
            return tit.get(0);
        }
        else{
            return  null;
        }
    }
}
