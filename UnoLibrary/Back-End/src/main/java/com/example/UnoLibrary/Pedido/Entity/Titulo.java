package com.example.UnoLibrary.Pedido.Entity;

import com.example.UnoLibrary.Pedido.Conexao;
import com.example.UnoLibrary.Pedido.DAL.TituloDAL;

import java.util.List;

public class Titulo{
    private Long id;
    private String nome;
    private int qtde;
    private int edicao;
    private String genero;

    public Titulo() {
    }

    public Titulo(Long id, String nome, int qtde, int edicao, String genero) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
        this.edicao = edicao;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Titulo> buscaTitulo(String nome, int edicao, Conexao conexao) {
        TituloDAL tituloDAL = new TituloDAL();
        return tituloDAL.get("tit_nome = '"+nome + "'and tit_edicao="+edicao,conexao);
    }
}
