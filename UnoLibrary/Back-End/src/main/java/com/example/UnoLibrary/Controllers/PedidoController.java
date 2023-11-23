package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.entity.ItemPedido;
import com.example.UnoLibrary.Model.entity.Pedido;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.ItemPedidoRepository;
import com.example.UnoLibrary.Model.repository.JuridicaRepository;
import com.example.UnoLibrary.Model.repository.PedidoRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.lang.Integer.parseInt;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/UnoLibrary/Front-End")
public class PedidoController
{

    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private ItemPedidoRepository itemRepository;
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private JuridicaRepository juridicoRepository;


    @GetMapping(value = "/itempedido/verifica-livro")
    public ResponseEntity<Object> verificaLivro(@RequestParam("nome")String nome, @RequestParam("edicao")int edicao)
    {
        List<Titulo> tit = this.tituloRepository.findByTitulo(nome);
        if (tit.size() > 0)
            for (Titulo t: tit)
            {
                if (t.getEdicao() == edicao)
                    return ResponseEntity.ok().body("titulo encontrado");
            }

        return ResponseEntity.badRequest().body("titulo nao encontrado");

    }

    @PostMapping(value = "/itempedido/salvarpedido")
    public ResponseEntity<Object> salvarPedido(@RequestParam("nome")String nome,@RequestParam("edicao")int edicao, @RequestParam("quantidade")int quantidade)
    {

        Titulo titulo = new Titulo();

        List<Titulo> tit = this.tituloRepository.findByTitulo(nome);
        if (tit.size() > 0)
            for (Titulo t: tit)
            {
                if (t.getEdicao() == edicao)
                    titulo = t;
            }

        Pedido pedido = repository.save(new Pedido(0L,1L,new Date(),generateDateAfterSevenDays()));
        itemRepository.save(new ItemPedido(pedido.getPed_id(),titulo.getId(),quantidade));
        return ResponseEntity.ok().body("Sucesso");

    }
    public static Date generateDateAfterSevenDays()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7); // Adiciona 7 dias à data atual
        return calendar.getTime(); // Retorna a data como um objeto do tipo Date
    }
}
