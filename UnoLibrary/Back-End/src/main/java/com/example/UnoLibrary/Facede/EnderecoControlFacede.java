package com.example.UnoLibrary.Facede;

import com.example.UnoLibrary.Model.entity.Endereco;
import com.example.UnoLibrary.Model.repository.EnderecoRepository;
import org.springframework.stereotype.Controller;

@Controller
public class EnderecoControlFacede {
        private EnderecoRepository repo;

        public EnderecoControlFacede(EnderecoRepository repository) {
            this.repo = repository;
        }

        public Endereco inserir(Endereco end)
        {
            return repo.save(end);
        }

        public Endereco buscar(Long id)
        {
            return repo.getOne(id);
        }

}
