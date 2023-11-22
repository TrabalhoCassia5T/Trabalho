package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Juridica;
import com.example.UnoLibrary.Model.repository.JuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juridica")
public class JuridicaController {

    @Autowired
    private JuridicaRepository juridicaRepository;

    @GetMapping("listarTodos")
    public List<Juridica> listarTodos() {
        return juridicaRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Juridica cadastrar(@RequestBody Juridica juridica) {
        return juridicaRepository.save(juridica);
    }

    @PutMapping("alterar/{id}")
    public Juridica alterar(@PathVariable Long id, @RequestBody Juridica juridicaAtualizada) {
        return juridicaRepository.findById(id)
                .map(juridica -> {
                    juridica.setCnpj(juridicaAtualizada.getCnpj());
                    juridica.setRazaoSocial(juridicaAtualizada.getRazaoSocial());
                    return juridicaRepository.save(juridica);
                })
                .orElseThrow(() -> new RuntimeException("Jurídica não encontrada com o ID: " + id));
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable Long id) {
        juridicaRepository.deleteById(id);
    }
}
