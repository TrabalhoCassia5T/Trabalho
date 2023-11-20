package com.example.UnoLibrary.Facede;

import com.example.UnoLibrary.Model.entity.EmprestimoExemplar;
import com.example.UnoLibrary.Model.repository.EmprestimoExemplarRepository;

public class EmprestimoExemplarControlFacede {
     private EmprestimoExemplarRepository repo;

        public EmprestimoExemplarControlFacede(EmprestimoExemplarRepository repository) {
            this.repo = repository;
        }

        public EmprestimoExemplar inserir(EmprestimoExemplar data)
        {
            return repo.save(data);
        }

        public EmprestimoExemplar buscar(Long id)
        {
            return repo.getOne(id);
        }
}
