package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.DTOs.CorporacaoRequestDTO;
import com.example.UnoLibrary.Model.DTOs.CorporacaoResponseDTO;
import com.example.UnoLibrary.Model.Corporacao.*;
import com.example.UnoLibrary.Model.entity.Corporacao;
import com.example.UnoLibrary.Model.repository.CorporacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class CorporacaoController
{

    @Autowired
    private CorporacaoRepository repository;
    @Autowired
    private CorporacaoService repo;

    @PostMapping(value = "/cadastro")
    public ResponseEntity<Object> saveUser(@RequestParam ("bairro") String bairro, @RequestParam ("cep") String cep,
                                           @RequestParam ("cidade") String cidade, @RequestParam ("cnpj") String cnpj,
                                           @RequestParam ("complemento") String complemento, @RequestParam ("email") String email,
                                           @RequestParam ("inscricaoEstadual") String inscricaoestadual, //@RequestParam ("login") String login,
                                           @RequestParam ("logotipoGrande") MultipartFile logotipog, @RequestParam ("logotipoPequeno") MultipartFile logotipop,
                                           @RequestParam ("nomeFantasia") String nomeempresa, @RequestParam ("numero") String numero,
                                           @RequestParam ("razaoSocial") String razaosocial, @RequestParam ("rua") String rua,
                                           //@RequestParam ("senha") String senha, @RequestParam ("senhaconfirmada") String senhaconfirmada,
                                           @RequestParam ("site") String site, @RequestParam ("uf") String uf)
    {
        String senha = "teste", senhaconfirmada = "teste", login = "empresaTeste";
        CorporacaoRequestDTO data = new CorporacaoRequestDTO(login, nomeempresa, cnpj, razaosocial, inscricaoestadual,
                email, site, cep, cidade, uf, rua, bairro, numero, complemento, senha, senhaconfirmada, logotipog.getName(), logotipop.getName());
        Corporacao dados = new Corporacao(data);
        repo.save(dados);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping(value = "/verificar-login")
    public String verificalogin(@RequestParam("login")String login,@RequestParam("senha")String senha)
    {
        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();
        for(int i = 0; i< userlist.size();i++)
        {
            if(userlist.get(i).login().equals(login))
                return "Login bem sucedido";
        }
        return "Não existe Cadastro";
    }


    @GetMapping
    public List<CorporacaoResponseDTO> getall()
    {
        System.out.println("entrou aqui3");
        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();

        return userlist;
    }


}



