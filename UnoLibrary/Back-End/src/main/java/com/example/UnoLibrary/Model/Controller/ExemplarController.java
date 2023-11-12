package com.example.UnoLibrary.Model.Controller;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.AutorRepository;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exemplar")
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
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Exemplar exemplar) {
        return ResponseEntity.ok(repo.save(exemplar));
    }
    @GetMapping("excluir/{id}")
    public void apagar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
