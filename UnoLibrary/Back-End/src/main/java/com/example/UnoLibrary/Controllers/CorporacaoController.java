package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.Model.DTOs.CorporacaoRequestDTO;
import com.example.UnoLibrary.Model.DTOs.CorporacaoResponseDTO;
import com.example.UnoLibrary.Facede.EnderecoControlFacede;
import com.example.UnoLibrary.Model.Corporacao.*;
import com.example.UnoLibrary.Model.entity.Corporacao;
import com.example.UnoLibrary.Model.entity.Endereco;
import com.example.UnoLibrary.Model.repository.CorporacaoRepository;
import com.example.UnoLibrary.Model.repository.EnderecoRepository;


import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private HttpServletRequest request;
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
                                           @RequestParam ("logotipoGrande") MultipartFile logotipog, @RequestParam ("logotipoPequeno") MultipartFile logotipop,
                                           @RequestParam ("nomeFantasia") String nomeempresa, @RequestParam ("numero") String numero,
                                           @RequestParam ("razaoSocial") String razaosocial, @RequestParam ("rua") String rua,
                                           @RequestParam ("senha") String senha,
                                           @RequestParam ("site") String site, @RequestParam ("uf") String uf)
    {
        File logotipo = new File(getStaticPath()+LOGOTIPOS_FOLDER);
        if (!logotipo.exists())
            logotipo.mkdir();
        String logotipope = getStaticPath()+LOGOTIPOS_FOLDER+"\\"+logotipop.getName()+".jpg";
        Path root= Paths.get(".");
        try {
            Endereco end = new EnderecoControlFacede(endRepository).inserir(
                    new Endereco(0L, rua, numero, bairro, cep, cidade, uf)
            );
            CorporacaoRequestDTO data = new CorporacaoRequestDTO(login,nomeempresa,cnpj,razaosocial
                    ,inscricaoestadual,email,site, end.getEnd_id(), senha,logotipog.getName(),logotipope);
            Corporacao dados = new Corporacao(data);
            repo.save(dados);
            return ResponseEntity.ok().body("ok");
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/find-logo")
    public String findImage ()
    {
        String res = "";

        // busca as imagens na pasta static/musics
        File pastaweb = new File(getStaticPath()+LOGOTIPOS_FOLDER);
        for (File file : pastaweb.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".jpg"))
            {
                res = getHostStatic()+file.getName();
            }
        }
        return res;
    }


    public String getStaticPath()
    {
        String staticPath = null;
        try {
            staticPath = resourceLoader.getResource("classpath:static").getFile().getAbsolutePath();
        }catch (Exception e){}
        return staticPath;
    }
    /* retorna a url da pasta static/musics*/
    public String getHostStatic()
    {
        return "http://"+request.getServerName().toString()+":"+request.getServerPort()+LOGOTIPOS_FOLDER+"/";
    }

    @GetMapping(value = "/verificar")
    public String verificalogin()
    {
        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();
        if(userlist.size() > 0) {
            return "Existe Cadastro";
        }
        return "Não existe Cadastro";
    }


    @GetMapping
    public List<CorporacaoResponseDTO> getall()
    {

        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();
        return userlist;
    }


}



