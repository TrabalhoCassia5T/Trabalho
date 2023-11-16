package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.DTOs.CorporacaoRequestDTO;
import com.example.UnoLibrary.Model.DTOs.CorporacaoResponseDTO;
import com.example.UnoLibrary.Facede.EnderecoControlFacede;
import com.example.UnoLibrary.Model.Corporacao.*;
import com.example.UnoLibrary.Model.entity.Corporacao;
import com.example.UnoLibrary.Model.entity.Endereco;
import com.example.UnoLibrary.Model.repository.CorporacaoRepository;
import com.example.UnoLibrary.Model.repository.EnderecoRepository;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class CorporacaoController
{
    private final static String LOGOTIPOS_FOLDER="/logotipos";
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private CorporacaoRepository repository;
    @Autowired
    private CorporacaoService repo;
    @Autowired
    private EnderecoRepository endRepository;

    @PostMapping(value = "/cadastro")
    public ResponseEntity<Object> saveUser(@RequestParam ("bairro") String bairro, @RequestParam ("cep") String cep,
                                           @RequestParam ("cidade") String cidade, @RequestParam ("cnpj") String cnpj,
                                           @RequestParam ("complemento") String complemento, @RequestParam ("email") String email,
                                           @RequestParam ("inscricaoEstadual") String inscricaoestadual, @RequestParam ("login") String login,
                                           @RequestParam ("logotipoGrande") String logotipog, @RequestParam ("logotipoPequeno") String logotipop,
                                           @RequestParam ("nomeFantasia") String nomeempresa, @RequestParam ("numero") String numero,
                                           @RequestParam ("razaoSocial") String razaosocial, @RequestParam ("rua") String rua,
                                           @RequestParam ("senha") String senha,
                                           @RequestParam ("site") String site, @RequestParam ("uf") String uf)
    {
        Endereco end = new EnderecoControlFacede(endRepository).inserir(
            new Endereco(0L, rua, numero, bairro, cep, cidade, uf)
        );
        File logotipo = new File(getStaticPath()+LOGOTIPOS_FOLDER);
        if (!logotipo.exists())
            logotipo.mkdir();
        //String logotipop = getStaticPath()+LOGOTIPOS_FOLDER+"\\"+login+"_"+nomeempresa+"_"+cnpj+".png";
        //String logotipog = getStaticPath()+LOGOTIPOS_FOLDER+"\\"+login+"_"+nomeempresa+"_"+cnpj+".png";
        Path root= Paths.get(".");
        try {
            //Files.copy(logotipope.getInputStream(), root.resolve(logotipop));
            //Files.copy(logotipogr.getInputStream(), root.resolve(logotipog));
            return ResponseEntity.ok("arquivo recebido");
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


        CorporacaoRequestDTO data = new CorporacaoRequestDTO(login,nomeempresa,cnpj,razaosocial
                ,inscricaoestadual,email,site, end.getEnd_id(), senha,logotipop,logotipop);
        Corporacao dados = new Corporacao(data);
        repo.save(dados);
        return ResponseEntity.ok().body("ok");
    }

    public String getStaticPath()
    {
        String staticPath = null;
        try {
            staticPath = resourceLoader.getResource("classpath:static").getFile().getAbsolutePath();
        }catch (Exception e){}
        return staticPath;
    }

    @PostMapping(value = "/verificar-login")
    public String verificalogin(@RequestParam("login")String login,@RequestParam("senha")String senha)
    {
        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();
        for(int i = 0; i< userlist.size();i++)
        {
            if(userlist.get(i).login().equals(login)) // compara login
                if(userlist.get(i).senha().equals(senha)) // compara senha
                    return "Login bem sucedido";
                else
                    return "Senha Incorreta";
            else
                return "Login Incorreto";
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



