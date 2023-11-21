package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.DTOs.BuscaClienteResponseDTO;
import com.example.UnoLibrary.Model.DTOs.BuscaFornecedoresResponseDTO;
import com.example.UnoLibrary.Model.entity.*;
import com.example.UnoLibrary.Model.repository.FornecedoresRepository;
import com.example.UnoLibrary.Model.repository.JuridicaRepository;
import com.example.UnoLibrary.Model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
@Controller
public class FornecedoresController {
    @Autowired
    private FornecedoresRepository repo;
    @Autowired
    private JuridicaRepository jurRepo;
    @Autowired
    private PessoaRepository pesRepo;

    
    @GetMapping(value = "/fornecedor/busca-fornecedores")
    public ResponseEntity<Object> getAllFornecedores() {
        List<BuscaFornecedoresResponseDTO> todos = new ArrayList<>();
        List<Fornecedores> forc = repo.findAll();
        System.out.println(forc);
        for (Fornecedores f : forc) {
            Juridica juridica = jurRepo.findById(f.getJuridica_jur_id()).get();
            Optional<Pessoa> pes = pesRepo.findById(juridica.getPessoa_pes_id());
            Pessoa pessoa = pes.get();
            todos.add(new BuscaFornecedoresResponseDTO(f.getFor_id(), juridica.getJur_razao_social(),
                        juridica.getJur_cnpj(), pessoa.getPes_telefone()));
            System.out.println(pessoa.getPes_nome());
        }
        System.out.println(todos.get(0).getCnpj());
        return ResponseEntity.ok(todos);
    }
}

