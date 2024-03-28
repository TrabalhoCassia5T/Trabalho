package com.example.UnoLibrary.Pedido.DAL;

import com.example.UnoLibrary.Pedido.Conexao;
import com.example.UnoLibrary.Pedido.Entity.ItemPedido;

import java.util.List;

public class ItemPedidoDAL implements IDAL<ItemPedido> {
    @Override
    public boolean gravar(ItemPedido entidade) {
        String sql="INSERT INTO public.item_pedido(pedido_ped_id,titulo_tit_id,itp_qtde) VALUES (#1, #2, #3)";
        sql=sql.replace("#1",""+entidade.getPed_id());
        sql=sql.replace("#2",""+ entidade.getPedido_tit_id());
        sql=sql.replace("#3",""+entidade.getPed_qtde());
        if(){
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public boolean alterar(ItemPedido entidade) {
        return false;
    }

    @Override
    public boolean apagar(ItemPedido entidade) {
        return false;
    }

    @Override
    public ItemPedido get(int id) {
        return null;
    }

    @Override
    public List<ItemPedido> get(String filtro, Conexao conexao) {
        return null;
    }
}
