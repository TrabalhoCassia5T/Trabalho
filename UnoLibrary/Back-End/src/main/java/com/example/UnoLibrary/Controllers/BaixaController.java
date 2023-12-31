package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.BaixaRepository;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import com.example.UnoLibrary.Model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RequestMapping(value = "/api/baixa")
@RestController
public class BaixaController {
    @Autowired
    private BaixaRepository repo;
    @Autowired
    private ExemplarRepository repoExe;
    @Autowired
    private UsuarioRepository repoU;
    @PostMapping("cadastrar/{motivo}/{desc}/{data}/{id_exe}")
    public ResponseEntity<Object> incluir(@PathVariable("motivo") String motivo,
                                          @PathVariable("desc") String desc,
                                          @PathVariable("data")LocalDate data,
                                          @PathVariable("id_exe") Long id_exe) {
        Baixa baixa = repo.findByExemplar(id_exe);
        if(baixa!=null){
            return ResponseEntity.ok().body("Baixa ja realizada nesse exemplar!");
        }
        else{
            Optional<Exemplar> exe = repoExe.findById(id_exe);
            if(!exe.isPresent()){
                return ResponseEntity.ok().body("Exemplar nao cadastrado!");
            }
            else{
                try{
                    Baixa baixaObj = new Baixa();
                    baixaObj.setMotivo(motivo);
                    baixaObj.setDesc(desc);
                    baixaObj.setData(data);
                    baixaObj.setExemplar(exe.get());
                    baixaObj.setUsuario(repoU.findById(1L).get());
                    repo.save(baixaObj);
                    return ResponseEntity.ok().body("Cadastrado com sucesso!");
                } catch (Exception e) {
                    // Outras exceções podem ocorrer
                    return ResponseEntity.ok().body("Erro durante o Cadastro!");
                }
            }
        }
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> buscarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("buscar_motivo/{motivo}")
    public ResponseEntity<Object> buscarMotivo(@PathVariable("motivo") String chave) {
        return ResponseEntity.ok(repo.findByChave(chave));
    }

    @GetMapping("buscar_motivo_data/{motivo}/{datI}/{datF}")
    public ResponseEntity<Object> buscarMotivoData(@PathVariable("motivo") String chave,
                                                   @PathVariable("datI") LocalDate dataI,
                                                   @PathVariable("datF") LocalDate dataF) {
        return ResponseEntity.ok(repo.findByChave2(chave,dataI,dataF));
    }

    @GetMapping("buscarId/{id}")
    public ResponseEntity<Object> buscarid(@PathVariable("id") Long id){
        Optional<Baixa> olivro=repo.findById(id);

        if(olivro.isEmpty())
            return ResponseEntity.badRequest().body("Baixa nao encontrado!");
        else
            return ResponseEntity.ok(olivro.get());
    }
    @GetMapping("buscar_data/{datI}/{datF}")
    public ResponseEntity<Object> buscarData(@PathVariable("datI") LocalDate dataI,
                                                   @PathVariable("datF") LocalDate dataF) {
        return ResponseEntity.ok(repo.findByChave3(dataI,dataF));
    }
    @PostMapping("alterar/{id}/{motivo}/{desc}/{data}/{exe_id}")
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id,
                                          @PathVariable("motivo") String motivo,
                                          @PathVariable("desc") String desc,
                                          @PathVariable("data") LocalDate data,
                                          @PathVariable("exe_id") Long exe_id) {
        Optional<Exemplar> tit = repoExe.findById(exe_id);
        if(tit.isEmpty()){
            return ResponseEntity.ok().body("Titulo nao cadastrado!");
        }
        else{
            Baixa exe = new Baixa();
            exe.setId(id);
            exe.setData(data);
            exe.setMotivo(motivo);
            exe.setExemplar(tit.get());
            exe.setDesc(desc);
            exe.setUsuario(repoU.findById(1L).get());
            try {
                repo.save(exe);
                return ResponseEntity.ok().body("Alteracao realizada com sucesso!");
            } catch (Exception e) {
                // Outras exceções podem ocorrer durante a exclusão
                return ResponseEntity.ok().body("Erro durante a alteracao!");
            }
        }
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
