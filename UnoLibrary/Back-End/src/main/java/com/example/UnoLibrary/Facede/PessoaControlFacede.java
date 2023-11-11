package com.example.UnoLibrary.Facede;
import com.example.UnoLibrary.Model.entity.Pessoa;
import com.example.UnoLibrary.Model.repository.PessoaRepository;
import org.springframework.stereotype.Controller;

@Controller
public class PessoaControlFacede {
    private PessoaRepository repo;
    public PessoaControlFacede(PessoaRepository repo) {this.repo = repo;}

    public Pessoa inserir(Pessoa pes){
        return repo.save(pes);
    }

    public Pessoa buscar(Long id){
        return repo.getById(id);
    }
}
