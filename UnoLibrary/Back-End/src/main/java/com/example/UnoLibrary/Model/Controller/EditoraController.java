package com.example.UnoLibrary.Model.Controller;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Editora;
import com.example.UnoLibrary.Model.repository.AutorRepository;
import com.example.UnoLibrary.Model.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {
    @Autowired
    private EditoraRepository repo;
    @PostMapping("cadastrar")
    public ResponseEntity<Object> incluir(@RequestBody Editora editora) {
        return ResponseEntity.ok(repo.save(editora));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }
    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Editora editora) {
        return ResponseEntity.ok(repo.save(editora));
    }
    @GetMapping("excluir/{id}")
    public void apagar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
