package com.example.UnoLibrary.Pedido.DAL;

import com.example.UnoLibrary.Pedido.DBSingleton;
import com.example.UnoLibrary.Pedido.Entity.Titulo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TituloDAL implements  IDAL<Titulo>  {
    @Override
    public boolean gravar(Titulo entidade) {
        return false;
    }

    @Override
    public boolean alterar(Titulo entidade) {
        return false;
    }

    @Override
    public boolean apagar(Titulo entidade) {
        return false;
    }

    @Override
    public Titulo get(int id) {
        return null;
    }
    @Override
    public List<Titulo> get(String filtro) {
        List<Titulo> clientes = new ArrayList<>();
        String sql="select * from titulo";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs= DBSingleton.getCon().consultar(sql);
        try {
            while (rs.next()) {
                clientes.add(new Titulo(rs.getLong("tit_id"),rs.getString("tit_nome"),
                        rs.getInt("tit_qtde"),rs.getInt("tit_edicao"),
                        rs.getString("tit_genero")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(clientes.size());
        return clientes;
    }
}
