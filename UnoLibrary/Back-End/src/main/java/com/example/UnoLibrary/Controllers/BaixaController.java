package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.repository.AutorRepository;
import com.example.UnoLibrary.Model.repository.BaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Baixa baixa) {
        return ResponseEntity.ok(repo.save(baixa));
    }
    @GetMapping("excluir/{id}")
    public void apagar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
