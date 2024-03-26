package com.example.UnoLibrary.Pedido;


import com.example.UnoLibrary.Pedido.Controle.PedidoControle;
import com.example.UnoLibrary.Pedido.Controle.TituloControle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api")
@RestController
public class PedidoController
{
    @GetMapping(value = "/itempedido/verifica-livro")
    public ResponseEntity<Object> verificaLivro(@RequestParam("nome")String nome, @RequestParam("edicao")int edicao) {
        TituloControle titulo = new TituloControle();
        if(titulo.buscaTitulo(nome,edicao) != null){
            return ResponseEntity.ok().body("titulo encontrado");
        }
        else{
            return ResponseEntity.badRequest().body("titulo nao encontrado");
        }
    }

    @PostMapping(value = "/itempedido/salvarpedido")
    public ResponseEntity<Object> salvarPedido(@RequestParam("nome")String nome,@RequestParam("edicao")int edicao, @RequestParam("quantidade")int quantidade) {
        PedidoControle pedido = new PedidoControle();
        if(pedido.salvarTitulo(nome,edicao,quantidade)){
            return ResponseEntity.ok().body("titulo cadastrado");
        }
        else{
            return  ResponseEntity.badRequest().body("titulo nao cadastrado");
        }
    }
}
