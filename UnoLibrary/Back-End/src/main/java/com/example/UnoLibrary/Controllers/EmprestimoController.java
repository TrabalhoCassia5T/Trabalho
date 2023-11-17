package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Facede.FisicaControlFacede;
import com.example.UnoLibrary.Facede.PessoaControlFacede;
import com.example.UnoLibrary.Model.entity.Cliente;
import com.example.UnoLibrary.Model.entity.Emprestimo;
import com.example.UnoLibrary.Model.entity.Fisica;
import com.example.UnoLibrary.Model.entity.Pessoa;
import com.example.UnoLibrary.Model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repository;
    @Autowired
    private ClientRepository cliRepo;
    @Autowired
    private PessoaRepository pesRepo;
    @Autowired
    private FisicaRepository fisRepo;

    @PostMapping(value = "/emprestimo/cadastrar")
    public ResponseEntity<Object> cadastrarEmprestimo(@RequestParam("num_cliente") int numero_cliente,
                                                      @RequestParam("nome_cliente") String nome_cliente,
                                                      @RequestParam("cod_livro") int cod_livro,
                                                      @RequestParam("nome_livro") String nome_livro,
                                                      @RequestParam("data_devolucao")Date data,
                                                      @RequestParam("status") String status,
                                                      @RequestParam("func_id") int func_id) {
        Optional<Cliente> cli = cliRepo.findById((long) numero_cliente);
        Fisica fis = new FisicaControlFacede(fisRepo).buscar(cli.get().getFisica_fis_id());
        Pessoa pes = new PessoaControlFacede(pesRepo).buscar(fis.getPessoa_pes_id());

        repository.save(new Emprestimo(0L, cli.get().getCli_id(), new Date(), data, (long) func_id, status));
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping(value = "/emprestimo/renovar/:id")
    public ResponseEntity<Object> renovarEmprestimo(@PathVariable("id") Long id) {
       Optional<Emprestimo> emp = repository.findById(id);
        if(emp.isEmpty()) {
            return ResponseEntity.badRequest().body("Id inválido");
        }
        Emprestimo emprestimo = emp.get();
        emprestimo.setEmp_prev_devolucao(generateDateAfterSevenDays());
        repository.save(emprestimo);
        return ResponseEntity.ok().body("ok");
    }

    public static Date generateDateAfterSevenDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7); // Adiciona 7 dias à data atual
        return calendar.getTime(); // Retorna a data como um objeto do tipo Date
    }
}
