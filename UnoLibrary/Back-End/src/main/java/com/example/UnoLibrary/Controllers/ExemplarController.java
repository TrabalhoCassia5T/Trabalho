package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.entity.Cliente;
import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.BaixaRepository;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/exemplar")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
public class ExemplarController {
    @Autowired
    private ExemplarRepository repo;
    @Autowired
    private TituloRepository repoT;
    @PostMapping("cadastrar/{status}/{data}/{titulo}")
    public ResponseEntity<Object> incluir(@PathVariable("status") String status,
                                          @PathVariable("data") LocalDate data,
                                          @PathVariable("titulo") String titulo) {
        Exemplar exemplar = new Exemplar();
        exemplar.setStatus(status);
        exemplar.setDataEntrada(data);
        List<Titulo> tit = repoT.findByTitulo(titulo);
        if(tit.size()>0){
            try{
                exemplar.setTitulo(tit.get(0));
                System.out.println(exemplar.getDataEntrada());
                System.out.println(exemplar.getTitulo().getNome());
                repo.save(exemplar);
                return ResponseEntity.ok().body("Cadastrado com sucesso!");
            } catch (Exception e) {
                // Outras exceções podem ocorrer
                return ResponseEntity.ok().body("Erro durante a exclusao!");
            }
        }
        else {
            return ResponseEntity.status(500).body("Titulo nao encontrado!");
        }
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("buscar_titulo/{titulo}")
    public ResponseEntity<Object> buscarTitulo(@PathVariable("titulo") String chave) {
        return ResponseEntity.ok(repo.findByChave(chave));
    }

    @GetMapping("buscar_titulo_data/{titulo}/{datI}/{datF}")
    public ResponseEntity<Object> buscarTituloData(@PathVariable("titulo") String chave,
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
    public ResponseEntity<Object> alterar(@RequestBody Exemplar exemplar) {
        return ResponseEntity.ok(repo.save(exemplar));
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