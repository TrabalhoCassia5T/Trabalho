package com.example.UnoLibrary.Pedido.DAL;

import com.example.UnoLibrary.Pedido.DBSingleton;
import com.example.UnoLibrary.Pedido.Entity.Pedido;
import com.example.UnoLibrary.Pedido.Entity.Titulo;

import java.util.List;

public class PedidoDAL implements  IDAL<Pedido>{
    @Override
    public boolean gravar(Pedido entidade) {
        String sql="INSERT INTO public.pedido(juridica_jur_id,ped_data,ped_data_entrega) VALUES (#2, '#3', '#4')";
        sql=sql.replace("#2",entidade.getJuridica_jur_id().toString());
        sql=sql.replace("#3",""+ entidade.getPed_data().toString());
        sql=sql.replace("#4",""+entidade.getPed_data_entrega().toString());
        System.out.println(sql);
        if(DBSingleton.getCon().manipular(sql)){
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public boolean alterar(Pedido entidade) {
        return false;
    }

    @Override
    public boolean apagar(Pedido entidade) {
        return false;
    }

    @Override
    public Pedido get(int id) {
        return null;
    }

    @Override
    public List<Pedido> get(String filtro) {
        return null;
    }

    public Long ultimoPedido(){
        Long codOp= (long) DBSingleton.getCon().getMaxPK("pedido","ped_id");
        return codOp;
    }
}
