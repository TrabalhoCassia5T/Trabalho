package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
    @Autowired
    private AutorRepository repo;
    @PostMapping("cadastrar")
    public ResponseEntity<Object> incluir(@RequestBody Autor autor) {
        return ResponseEntity.ok(repo.save(autor));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Autor autor) {
        return ResponseEntity.ok(repo.save(autor));
    }
    @GetMapping("excluir/{id}")
    public void apagar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
