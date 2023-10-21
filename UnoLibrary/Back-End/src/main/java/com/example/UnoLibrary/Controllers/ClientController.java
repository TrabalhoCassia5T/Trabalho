package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.Client.Client;
import com.example.UnoLibrary.Model.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping(value = "/cadastro-cliente")
    public ResponseEntity<Object> saveUser(@RequestBody Client dados)
    {
        // cadastro do usuario
        return ResponseEntity.ok().body("ok");
    }
}
