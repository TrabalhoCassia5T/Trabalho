package com.example.UnoLibrary.Facede;

import com.example.UnoLibrary.Model.entity.Fisica;
import com.example.UnoLibrary.Model.repository.FisicaRepository;
import org.springframework.stereotype.Controller;

@Controller
public class FisicaControlFacede {
    private FisicaRepository repo;

    public FisicaControlFacede(FisicaRepository repo){this.repo = repo;}

    public Fisica inserir(Fisica fis){
        return repo.save(fis);
    }

    public Fisica buscar(Long id){
        return repo.getById(id);
    }
}
