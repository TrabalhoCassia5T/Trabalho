package com.example.UnoLibrary.Controllers;

// import com.example.UnoLibrary.Facede.EmprestimoExemplarControlFacede;
// import com.example.UnoLibrary.Facede.FisicaControlFacede;
// import com.example.UnoLibrary.Facede.PessoaControlFacede;
import com.example.UnoLibrary.Model.entity.*;
import com.example.UnoLibrary.Model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private RecebimentoRepository recRepo;
     @Autowired
     private FisicaRepository fisRepo;
     @Autowired
     private  EmprestimoExemplarRepository emprestimoExemplarRepo;
    @Autowired
    private TituloRepository titRepo;
    @Autowired
    private ExemplarRepository exempRepo;

    @PostMapping(value = "/emprestimo/cadastrar")
    public ResponseEntity<Object> cadastrarEmprestimo(@RequestParam("cpf_cliente") String numero_cliente,
                                                      @RequestParam("nome_cliente") String nome_cliente,
                                                      @RequestParam("cod_livro") String cod_livro,
                                                      @RequestParam("nome_livro") String nome_livro,
                                                      @RequestParam("data_devolucao")Date data,
                                                      @RequestParam("status") String status,
                                                      @RequestParam("func_id") int func_id
                                                      ) {
        List<Fisica> fisica = fisRepo.findByCpf(numero_cliente);
        Cliente cliente = cliRepo.findByFisicaId(fisica.get(0).getFis_id()); // para pegar o id do cliente
        String[] codigos = cod_livro.split(",");
        for (String exemplarCod : codigos){
            Optional<Exemplar> exep = exempRepo.findById(Long.parseLong(exemplarCod));
            if(exep.isEmpty()){
                return ResponseEntity.badRequest().body("Exemplar "+exemplarCod+" inexistente");
            }
            Exemplar exemplar = exep.get();
            Optional<Titulo> tit = titRepo.findById(exemplar.getTitulo().getId());
            Titulo titulo = tit.get();
            if(titulo.getQtde() == 0) { // verifica disponibilidade do livro
                return ResponseEntity.badRequest().body("Exemplar "+exemplarCod+" não disponível no momento");
            }
            titulo.setQtde(titulo.getQtde()-1); // atualiza o acervo
            titRepo.save(titulo);
        }
        Emprestimo emprestimo = repository.save(new Emprestimo(0L, cliente.getCli_id(), new Date(), generateDateAfterSevenDays(), (long) func_id, status));
        System.out.println(emprestimo.getEmp_id());
        for (String exemplarCod : codigos){
            System.out.println("aqui ??");
            Exemplar exemplar = exempRepo.findById(Long.parseLong(exemplarCod)).get(); // preenche a tabela de junção
            emprestimoExemplarRepo.save(new EmprestimoExemplar(emprestimo.getEmp_id(), exemplar.getId(), generateDateAfterSevenDays()));
        }
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping(value = "/emprestimo/verifica/cliente")
    public ResponseEntity<Object> verificaCliente(@RequestParam("id") Long id) {
        System.out.println(id);
        List<Emprestimo> emp = repository.findByClienteId(id);
        if(emp.size() > 0){
            for(Emprestimo e : emp) {
                Optional<Recebimento> rec = recRepo.findByEmpId(e.getEmp_id());
                if(rec.isPresent() && rec.get().getRec_data() == null) {
                    return ResponseEntity.badRequest().body("Pagamento em aberto");
                }
            }
        }
        return ResponseEntity.ok().body("ok");
    }

    public static Date generateDateAfterSevenDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7); // Adiciona 7 dias à data atual
        return calendar.getTime(); // Retorna a data como um objeto do tipo Date
    }
}
