package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Facede.EnderecoControlFacede;
import com.example.UnoLibrary.Facede.TituloControlFacede;
import com.example.UnoLibrary.Model.DTOs.BuscaFornecedoresResponseDTO;
import com.example.UnoLibrary.Model.DTOs.CorporacaoResponseDTO;
import com.example.UnoLibrary.Model.DTOs.TituloResponseDTO;
import com.example.UnoLibrary.Model.entity.Endereco;
import com.example.UnoLibrary.Model.entity.Fornecedores;
import com.example.UnoLibrary.Model.entity.Titulo;
import com.example.UnoLibrary.Model.repository.ItemPedidoRepository;
import com.example.UnoLibrary.Model.repository.TituloRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class ItemPedidoController
{
    private ItemPedidoRepository repo;
    private TituloRepository repository;
    private TituloRepository endRepository;


    @PostMapping(value = "/itempedido/verifica-livro")
    public String verificaLivro(@RequestParam("nome")String nome, @RequestParam ("qtde")int qtde,@RequestParam ("edicao") int edicao,@RequestParam("genero")String genero)
    {

        List<Titulo> tit = repository.findAll();
        System.out.println(tit);
        for (Titulo t:tit)
            if(t.getNome().equals(nome))
                return "Existe";

        Titulo titulo = new TituloControlFacede(endRepository).inserir(
                new Titulo(end.getEnd_id(),nome,qtde,edicao,genero);
    }
}
