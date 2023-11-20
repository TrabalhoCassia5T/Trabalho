package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.repository.FornecedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/fornecedor")
@RestController
@CrossOrigin
public class FornecedorController
{
    private FornecedorRepository repo;
    @PostMapping(value = "/busca-fornecedor")
    public ResponseEntity<Object> buscarTodos()
        {
            String token="sdsd";
            return ResponseEntity.ok(repo.findAll());
        }

}
