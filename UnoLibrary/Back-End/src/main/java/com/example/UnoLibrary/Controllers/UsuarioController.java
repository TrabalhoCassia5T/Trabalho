package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Usuario;
import com.example.UnoLibrary.Model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
