package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.repository.AutorRepository;
import com.example.UnoLibrary.Model.repository.BaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping(value = "/api/baixa")
@RestController
public class BaixaController {
    @Autowired
    private BaixaRepository repo;
    @PostMapping("cadastrar")
    public ResponseEntity<Object> incluir(@RequestBody Baixa baixa) {
        return ResponseEntity.ok(repo.save(baixa));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("buscar_motivo/{motivo}")
    public ResponseEntity<Object> buscarMotivo(@PathVariable("motivo") String chave) {
        return ResponseEntity.ok(repo.findByChave(chave));
    }

    @GetMapping("buscar_motivo_data/{motivo}/{datI}/{datF}")
    public ResponseEntity<Object> buscarMotivoData(@PathVariable("motivo") String chave,
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
    public ResponseEntity<Object> alterar(@RequestBody Baixa baixa) {
        return ResponseEntity.ok(repo.save(baixa));
    }
    @GetMapping("excluir/{id}")
    public ResponseEntity<Object> apagar(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            return ResponseEntity.ok().body("Exclusao realizada com sucesso!");
        } catch (Exception e) {
            // Outras exceções podem ocorrer durante a exclusão
            return ResponseEntity.ok().body("Erro durante a exclusao!");
        }
    }

    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repo.findById(id));
    }
}
