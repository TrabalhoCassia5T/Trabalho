package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.Corporacao.FornecedoresService;
import com.example.UnoLibrary.Model.entity.Fornecedores;
import com.example.UnoLibrary.Model.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/fornecedor")
@RestController
@CrossOrigin
public class FornecedoresController
{
    @Autowired
    private FornecedoresService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedores>> getFornecedores(@RequestParam(name = "search", required = false) String search) {
        List<Fornecedores> fornecedores;

        if (search != null && !search.isEmpty()) {
            fornecedores = fornecedorService.searchFornecedores(search);
        } else {
            fornecedores = fornecedorService.getAllFornecedores();
        }

        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

}
