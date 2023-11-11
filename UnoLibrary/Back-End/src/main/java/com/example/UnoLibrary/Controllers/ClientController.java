package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.Client.Client;
import com.example.UnoLibrary.Model.Client.ClientRepository;
import com.example.UnoLibrary.Model.Client.ClientRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping(value = "/cadastro-cliente")
    public ResponseEntity<Object> saveClient(@RequestParam("nome") String nome,
                                             @RequestParam("sobrenome") String sobrenome,
                                             @RequestParam("cpf") String cpf,
                                             @RequestParam("dataNasc") String dataNasc,
                                             @RequestParam("email") String email,
                                             @RequestParam("telefone") String telefone,
                                             @RequestParam("endereco") String endereco,
                                             @RequestParam("uf") String estado,
                                             @RequestParam("cep") String cep,
                                             @RequestParam("cidade") String cidade)
    {
        ClientRequestDTO dados = new ClientRequestDTO(nome, sobrenome, telefone, cpf, endereco, cidade, dataNasc, email, cep, estado);
        Client data = new Client(dados);
        repository.save(data);
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping(value = "/busca-cliente-cpf")
    public ResponseEntity<Object> findByCpf(@RequestParam("cpf") String cpf)
    {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }

    @GetMapping(value = "/busca-clientes")
    public ResponseEntity<Object> findAllClients()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/busca-cliente-nome")
    public ResponseEntity<Object> findById(@RequestParam("nome") String nome)
    {
        return ResponseEntity.ok(repository.findByNome(nome));
    }

    @PutMapping("/alterar-cliente")
    public ResponseEntity<Object> updateClient(@RequestParam("nome") String nome,
                                               @RequestParam("sobrenome") String sobrenome,
                                                @RequestParam("cpf") String cpf,
                                                @RequestParam("dataNasc") String dataNasc,
                                                @RequestParam("email") String email,
                                                @RequestParam("telefone") String telefone,
                                                @RequestParam("endereco") String endereco,
                                                @RequestParam("uf") String estado,
                                                @RequestParam("cep") String cep,
                                                @RequestParam("cidade") String cidade)
    {
        ClientRequestDTO dados = new ClientRequestDTO(nome, sobrenome, telefone, cpf, endereco, cidade, dataNasc, email, cep, estado);
        Client data = new Client(dados);
        List<Client> client = repository.findByCpf(cpf);
        repository.deleteById(client.get(0).getId());
        repository.save(data);
        return ResponseEntity.ok().body("Cliente alterado");
    }

    @GetMapping("/apagar-cliente/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id)
    {
        repository.deleteById(id);
        return ResponseEntity.ok().body("ok");
    }
}
