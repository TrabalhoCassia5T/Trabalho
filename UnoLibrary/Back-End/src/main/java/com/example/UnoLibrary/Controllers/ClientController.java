package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Facede.EnderecoControlFacede;
import com.example.UnoLibrary.Facede.FisicaControlFacede;
import com.example.UnoLibrary.Facede.PessoaControlFacede;
import com.example.UnoLibrary.Model.DTOs.BuscaClienteResponseDTO;
import com.example.UnoLibrary.Model.entity.Cliente;
import com.example.UnoLibrary.Model.entity.Endereco;
import com.example.UnoLibrary.Model.entity.Fisica;
import com.example.UnoLibrary.Model.entity.Pessoa;
import com.example.UnoLibrary.Model.repository.ClientRepository;
import com.example.UnoLibrary.Model.repository.EnderecoRepository;
import com.example.UnoLibrary.Model.repository.FisicaRepository;
import com.example.UnoLibrary.Model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
@Controller
public class ClientController {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private EnderecoRepository endRepo;
    @Autowired
    private PessoaRepository pesRepo;
    @Autowired
    private FisicaRepository fisRepo;

    @PostMapping(value = "/cadastro-cliente")
    public ResponseEntity<Object> saveClient(@RequestParam("nome") String nome,
                                             @RequestParam("telefone") String telefone,
                                             @RequestParam("email") String email,
                                             @RequestParam("url") String url,
                                             @RequestParam("cpf") String cpf,
                                             @RequestParam("dataNasc") String dataNasc,
                                             @RequestParam("estCivil") String estCivil,
                                             @RequestParam("sexo") String sexo,
                                             @RequestParam("rua") String rua,
                                             @RequestParam("numero") String numero,
                                             @RequestParam("bairro") String bairro,
                                             @RequestParam("uf") String estado,
                                             @RequestParam("cep") String cep,
                                             @RequestParam("cidade") String cidade)
    {
        Endereco end = new EnderecoControlFacede(endRepo).inserir(
                new Endereco(0L, rua, numero, bairro, cep, cidade, estado)
        );
        Pessoa pes = new PessoaControlFacede(pesRepo).inserir(
                new Pessoa(0L, end.getEnd_id(), nome, telefone, email, url)
        );
        Fisica fis = new FisicaControlFacede(fisRepo).inserir(
                new Fisica(0L, cpf, new Date(dataNasc), estCivil, sexo, pes.getPes_id())
        );
        repository.save(new Cliente(0L, new Date(), fis.getFis_id()));
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping(value = "/busca-cliente-cpf")
    public ResponseEntity<Object> findByCpf(@RequestParam("cpf") String cpf)
    {
        System.out.println(cpf);
        List<Fisica> fis = fisRepo.findByCpf(cpf);
        Fisica pessoaFisica = fis.get(0);
        Optional<Pessoa> pes = pesRepo.findById(pessoaFisica.getPessoa_pes_id());
        Pessoa pessoa = pes.get();
        Optional<Endereco> end = endRepo.findById(pessoa.getEnd_id());
        Endereco endereco = end.get();
        Cliente cli = repository.findByFisicaId(pessoaFisica.getFis_id());
        return ResponseEntity.ok().body(new BuscaClienteResponseDTO(cli.getCli_id(),
                pessoa.getPes_nome(), pessoaFisica.getFis_cpf(), pessoa.getPes_email(),
                pessoa.getPes_url(), pessoaFisica.getFis_estCivil(), pessoa.getPes_telefone(),
                endereco.getEnd_rua(), endereco.getEnd_numero(), endereco.getEnd_bairro(),
                endereco.getEnd_cidade(), endereco.getEnd_cep(), endereco.getEnd_uf(),
                pessoaFisica.getFis_sexo(), pessoaFisica.getFis_dataNasc()));
    }

    @GetMapping(value = "/busca-clientes")
    public ResponseEntity<Object> findAllClients()
    {
        List<BuscaClienteResponseDTO> todos = new ArrayList<>();
        List<Fisica> fis = fisRepo.findAll();
        for (Fisica f : fis){
            Optional<Pessoa> pes = pesRepo.findById(f.getPessoa_pes_id());
            Pessoa pessoa = pes.get();
            Optional<Endereco> end = endRepo.findById(pessoa.getEnd_id());
            Endereco endereco = end.get();
            System.out.println("cpf:"+f.getFis_cpf());
            System.out.println("id:"+f.getFis_id());
            Cliente cli = repository.findByFisicaId(f.getFis_id());
            System.out.println("Cliente id:"+cli.getCli_id());
            todos.add(new BuscaClienteResponseDTO(cli.getCli_id(),
                    pessoa.getPes_nome(), f.getFis_cpf(), pessoa.getPes_email(),
                    pessoa.getPes_url(), f.getFis_estCivil(), pessoa.getPes_telefone(),
                    endereco.getEnd_rua(), endereco.getEnd_numero(), endereco.getEnd_bairro(),
                    endereco.getEnd_cidade(), endereco.getEnd_cep(), endereco.getEnd_uf(),
                    f.getFis_sexo(), f.getFis_dataNasc()));
        }

        return ResponseEntity.ok(todos);
    }

    @GetMapping(value = "/busca-cliente-nome")
    public ResponseEntity<Object> findByNome(@RequestParam("nome") String nome)
    {
        List<BuscaClienteResponseDTO> todos = new ArrayList<>();
        List<Pessoa> pes = pesRepo.findByNome(nome.toUpperCase());
        for (Pessoa p : pes){
            Optional<Endereco> end = endRepo.findById(p.getEnd_id());
            Endereco endereco = end.get();
            Fisica fis = fisRepo.findByPessoaId(p.getPes_id());
            Cliente cli = repository.findByFisicaId(fis.getFis_id());
            todos.add(new BuscaClienteResponseDTO(cli.getCli_id(),
                    p.getPes_nome(), fis.getFis_cpf(), p.getPes_email(),
                    p.getPes_url(), fis.getFis_estCivil(), p.getPes_telefone(),
                    endereco.getEnd_rua(), endereco.getEnd_numero(), endereco.getEnd_bairro(),
                    endereco.getEnd_cidade(), endereco.getEnd_cep(), endereco.getEnd_uf(),
                    fis.getFis_sexo(), fis.getFis_dataNasc()));
        }
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/alterar-cliente")
    public ResponseEntity<Object> updateClient(@RequestParam("nome") String nome,
                                               @RequestParam("telefone") String telefone,
                                               @RequestParam("email") String email,
                                               @RequestParam("url") String url,
                                               @RequestParam("cpf") String cpf,
                                               @RequestParam("dataNasc") String dataNasc,
                                               @RequestParam("estCivil") String estCivil,
                                               @RequestParam("sexo") String sexo,
                                               @RequestParam("rua") String rua,
                                               @RequestParam("numero") String numero,
                                               @RequestParam("bairro") String bairro,
                                               @RequestParam("uf") String estado,
                                               @RequestParam("cep") String cep,
                                               @RequestParam("cidade") String cidade)
    {

        List<Fisica> pessoaCpf = fisRepo.findByCpf(cpf);
        System.out.println(pessoaCpf.get(0).getFis_cpf());
        Cliente cliente = repository.findByFisicaId(pessoaCpf.get(0).getFis_id());
        System.out.println(cliente.getFisica_fis_id());
        Optional<Pessoa> pessoaOptional = pesRepo.findById(pessoaCpf.get(0).getPessoa_pes_id());
        Pessoa pessoa = pessoaOptional.get();
        System.out.println(pessoa.getPes_nome());
        repository.deleteById(cliente.getCli_id());
        fisRepo.deleteById(pessoaCpf.get(0).getFis_id());
        pesRepo.deleteById(pessoa.getPes_id());
        endRepo.deleteById(pessoa.getEnd_id());

        Endereco end = new EnderecoControlFacede(endRepo).inserir(
                new Endereco(0L, rua, numero, bairro, cep, cidade, estado)
        );
        Pessoa pes = new PessoaControlFacede(pesRepo).inserir(
                new Pessoa(0L, end.getEnd_id(), nome, telefone, email, url)
        );
        Fisica fis = new FisicaControlFacede(fisRepo).inserir(
                new Fisica(0L, cpf, new Date(dataNasc), estCivil, sexo, pes.getPes_id())
        );
        repository.save(new Cliente(0L, new Date(), fis.getFis_id()));
        return ResponseEntity.ok().body("Cliente alterado");
    }

    @GetMapping("/apagar-cliente/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id)
    {
        Optional<Cliente> cli = repository.findById(id);
        Cliente cliente = cli.get();
        Optional<Fisica> fis = fisRepo.findById(cliente.getFisica_fis_id());
        Fisica fisica = fis.get();
        Optional<Pessoa> pes = pesRepo.findById(fisica.getPessoa_pes_id());
        Pessoa pessoa = pes.get();
        repository.deleteById(id);
        fisRepo.deleteById(fisica.getFis_id());
        pesRepo.deleteById(pessoa.getPes_id());
        endRepo.deleteById(pessoa.getEnd_id());
        return ResponseEntity.ok().body("ok");
    }
}
