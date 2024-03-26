package com.example.UnoLibrary.Pedido.Controle;

import com.example.UnoLibrary.Pedido.DBSingleton;
import com.example.UnoLibrary.Pedido.Entity.Titulo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TituloControle {

    public Titulo buscaTitulo(String nome, int edicao) {
        Titulo titulo = new Titulo();
        List<Titulo> tit = titulo.buscaTitulo(nome,edicao);
        if(tit.size() > 0){
            return tit.get(0);
        }
        else{
            return  null;
        }
    }
}
