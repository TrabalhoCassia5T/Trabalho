package com.example.UnoLibrary.Model.Controller;

import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/titulo")
public class TituloController {
    @Autowired
    private TituloRepository repo;
    @PostMapping("cadastrar")
    public ResponseEntity<Object> incluir(@RequestBody Titulo titulo) {
        return ResponseEntity.ok(repo.save(titulo));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Titulo titulo) {
        return ResponseEntity.ok(repo.save(titulo));
    }
    @GetMapping("excluir/{id}")
    public void apagar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
