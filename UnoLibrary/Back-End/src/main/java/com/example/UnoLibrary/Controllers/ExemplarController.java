package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.repository.BaixaRepository;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping(value = "/api/exemplar")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
public class ExemplarController {
    @Autowired
    private ExemplarRepository repo;
    @PostMapping("cadastrar")
    public ResponseEntity<Object> incluir(@RequestBody Exemplar exemplar) {
        return ResponseEntity.ok(repo.save(exemplar));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("buscar_titulo/{titulo}")
    public ResponseEntity<Object> buscarTitulo(@PathVariable("titulo") String chave) {
        return ResponseEntity.ok(repo.findByChave(chave));
    }

    @GetMapping("buscar_titulo_data/{titulo}/{datI}/{datF}")
    public ResponseEntity<Object> buscarTituloData(@PathVariable("titulo") String chave,
                                                   @PathVariable("datI") LocalDate dataI,
                                                   @PathVariable("datF") LocalDate dataF) {
        return ResponseEntity.ok(repo.findByChave2(chave,dataI,dataF));
    }

    @GetMapping("buscar_data/{datI}/{datF}")
    public ResponseEntity<Object> buscarData(@PathVariable("datI") LocalDate dataI,
                                                   @PathVariable("datF") LocalDate dataF) {
        return ResponseEntity.ok(repo.findByChave3(dataI,dataF));
    }
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Exemplar exemplar) {
        return ResponseEntity.ok(repo.save(exemplar));
    }
    @GetMapping("excluir/{id}")
    public ResponseEntity<Object> apagar(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            return ResponseEntity.ok().body("Exclusão realizada com sucesso");
        } catch (Exception e) {
            // Outras exceções podem ocorrer durante a exclusão
            return ResponseEntity.ok().body("Erro durante a exclusão!");
        }
    }

    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repo.findById(id));
    }
}