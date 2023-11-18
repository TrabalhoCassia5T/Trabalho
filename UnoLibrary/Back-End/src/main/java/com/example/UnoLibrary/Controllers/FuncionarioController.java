package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Funcionario;
import com.example.UnoLibrary.Model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping("cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioRepository.save(funcionario));
    }

    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(funcionarioRepository.findAll());
    }

    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioRepository.save(funcionario));
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}
