package com.example.UnoLibrary.Facede;

import com.example.UnoLibrary.Model.entity.Fisica;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.FisicaRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;

public class TituloControlFacede
{
    private TituloRepository repo;

    public TituloControlFacede(TituloRepository repo)
    {
        this.repo = repo;
    }

    public Titulo inserir(Titulo tit){
        return repo.save(tit);
    }

    public Titulo buscar(Long id){
        return repo.getById(id);
    }
}
