package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.Juridica;
import com.example.UnoLibrary.Model.entity.Pedido;
import com.example.UnoLibrary.Model.repository.JuridicaRepository;
import com.example.UnoLibrary.Model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private JuridicaRepository juridicaRepository;

    @GetMapping("listarTodos")
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @PostMapping("cadastrar")
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        Juridica juridica = pedido.getJuridica();
        juridicaRepository.save(juridica);
        return pedidoRepository.save(pedido);
    }

    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
