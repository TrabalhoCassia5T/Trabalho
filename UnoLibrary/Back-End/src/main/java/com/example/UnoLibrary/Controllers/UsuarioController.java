package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Usuario;
import com.example.UnoLibrary.Model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
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

    @PutMapping("alterar/{id}")
    public ResponseEntity<Object> alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtual) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuarioEx = usuarioRepository.getById(id);

        usuarioEx.setUsu_login(usuarioAtual.getUsu_login());
        usuarioEx.setUsu_senha(usuarioAtual.getUsu_senha());
        usuarioEx.setUsu_data_perm(usuarioAtual.getUsu_data_perm());
        usuarioEx.setUsu_data_desativa(usuarioAtual.getUsu_data_desativa());
        usuarioEx.setUsu_nivel(usuarioAtual.getUsu_nivel());

        Usuario usuario = usuarioRepository.save(usuarioEx);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
