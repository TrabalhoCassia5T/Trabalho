package com.example.UnoLibrary.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
public class PedidoController {
    @GetMapping(value = "/itempedido/verifica-livro")
    public ResponseEntity<Object> verificaLivro(@RequestParam("nome")String nome, @RequestParam("edicao")int edicao)
    {
        PedidoControle pedidoControle = new PedidoControle();
        if(pedidoControle.verificaLivro(nome,edicao)){
            return ResponseEntity.ok().body("Titulo encontrado");
        }
        else {
            return ResponseEntity.badRequest().body("Titulo nao encontrado");
        }
    }
}
