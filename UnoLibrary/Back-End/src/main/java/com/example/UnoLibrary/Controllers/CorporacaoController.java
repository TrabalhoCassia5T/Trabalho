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
        System.out.println(logotipope);
        Path root= Paths.get(".");
        try {
            System.out.println("ENTROU NO TRY");
            System.out.println(root.resolve(logotipope));
//            Files.copy(logotipop.getInputStream(),root.resolve(logotipope));
//            System.out.println("passou copy");
//            String imageP = findImage(logotipop.getName());
//            System.out.println(imageP);
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
        System.out.println("busca imagem");
        // busca as imagens na pasta static/musics
        File pastaweb = new File(getStaticPath()+LOGOTIPOS_FOLDER);
        System.out.println(pastaweb.listFiles());
        for (File file : pastaweb.listFiles()) {
            System.out.println("entrou no for");
            if (file.isFile() && file.getName().endsWith(".jpg"))
            {
                System.out.println("chegou");
                res = getHostStatic()+file.getName();
                System.out.println(res);
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

    @PostMapping(value = "/verificar-login")
    public String verificalogin(@RequestParam("login")String login,@RequestParam("senha")String senha)
    {
        System.out.println("teste1");
        List<CorporacaoResponseDTO> userlist = repository.findAll().stream().map(CorporacaoResponseDTO::new).toList();
        System.out.println("teste2");
        for(int i = 0; i< userlist.size();i++)
        {
            System.out.println("dentro do for");
            if(userlist.get(i).pam_login().equals(login)) // compara login
                if(userlist.get(i).pam_senha().equals(senha)) // compara senha
                    return "Login bem sucedido";
                else
                    return "Não existe Cadastro";
            else
                return "Não existe Cadastro";
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



