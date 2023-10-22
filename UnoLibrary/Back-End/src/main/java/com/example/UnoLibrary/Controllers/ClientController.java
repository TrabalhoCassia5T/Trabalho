package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.Client.Client;
import com.example.UnoLibrary.Model.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping(value = "/cadastro-cliente")
    public ResponseEntity<Object> saveClient(@RequestBody Client dados)
    {
        repository.save(dados);
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping(value = "/busca-cliente-cpf/{cpf}")
    public ResponseEntity<Object> findByCpf(@PathVariable("cpf") String cpf)
    {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }

    @GetMapping(value = "/busca-clientes")
    public ResponseEntity<Object> findAllClients()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/busca-cliente-id/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id)
    {
        Optional<Client> cliente = repository.findById(id);
        if(cliente.isEmpty())
        {
            return ResponseEntity.badRequest().body("Cliente não encontrado");
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping("/alterar-cliente")
    public ResponseEntity<Object> updateClient(@RequestBody Client dados)
    {
        return ResponseEntity.ok(repository.save(dados));
    }

    @GetMapping("/apagar-cliente/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
