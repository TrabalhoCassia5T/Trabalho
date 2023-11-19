package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.repository.ExemplarRepository;
import com.example.UnoLibrary.Seguranca.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Alterar

@RestController
@RequestMapping("/security")
public class AcessoController {
    @GetMapping("login/{usuario}/{senha}")
    public ResponseEntity<Object> login(@PathVariable("usuario") String usuario,
                                        @PathVariable("senha") String senha) {
        String token;
        if(senha.equals(senha)) {
            // gerar token
            token= JWTTokenProvider.getToken(usuario,"admin");
            return ResponseEntity.ok(token);
        }
        else
            return ResponseEntity.badRequest().body("Usuario não autenticado");
    }
}
