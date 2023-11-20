package com.example.UnoLibrary.Model.Corporacao;

import com.example.UnoLibrary.Model.entity.Fornecedores;
import com.example.UnoLibrary.Model.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class FornecedoresService
{
    @Autowired
    private FornecedoresRepository fornecedorRepository;

    public List<Fornecedores> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    public List<Fornecedores> searchFornecedores(String searchTerm) {
        // Implemente a lógica de pesquisa com base no searchTerm
        // Este é um exemplo simples, você pode ajustá-lo conforme necessário
        return fornecedorRepository.findByNomeContainingIgnoreCase(searchTerm);
    }

}
