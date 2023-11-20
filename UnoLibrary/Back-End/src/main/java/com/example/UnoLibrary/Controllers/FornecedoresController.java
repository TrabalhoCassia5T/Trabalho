package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.DTOs.BuscaClienteResponseDTO;
import com.example.UnoLibrary.Model.DTOs.BuscaFornecedoresResponseDTO;
import com.example.UnoLibrary.Model.entity.*;
import com.example.UnoLibrary.Model.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/fornecedor")
@RestController
@CrossOrigin
public class FornecedoresController {
    @Autowired
    private FornecedoresRepository repo;

    @GetMapping(value = "/busca-fornecedores")
    public ResponseEntity<Object> getAllFornecedores() {
        List<BuscaFornecedoresResponseDTO> todos = new ArrayList<>();
        List<Fornecedores> fis = repo.findAll();
        System.out.println(fis);
        for (Fornecedores f : fis) {
            System.out.println(f.getNome());
            todos.add(new BuscaFornecedoresResponseDTO(f.getFor_id(), f.getNome()));
        }

        return ResponseEntity.ok(todos);
    }
}

