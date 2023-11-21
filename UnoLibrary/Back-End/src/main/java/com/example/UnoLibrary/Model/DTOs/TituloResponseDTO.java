package com.example.UnoLibrary.Model.DTOs;

import com.example.UnoLibrary.Model.entity.Corporacao;
import com.example.UnoLibrary.Model.entity.Titulo;

public class TituloResponseDTO
{
    private Long id;
    private String nome;
    private int qtde;
    private int edicao;
    private String genero;
    public TituloResponseDTO(Long id, String nome, int qtde, int edicao,String genero)
    {
        this.id =id;
        this.nome = nome;
        this.qtde = qtde;
        this.edicao=edicao;
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
}
