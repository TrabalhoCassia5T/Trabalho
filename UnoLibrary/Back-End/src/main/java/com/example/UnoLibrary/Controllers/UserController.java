package com.example.TelaLogin.Controllers;

<<<<<<< Updated upstream
import com.example.UnoLibrary.User.User;
import com.example.UnoLibrary.User.UserRepository;
import com.example.UnoLibrary.User.UserResponseDTO;
import com.example.UnoLibrary.User.UserService;
=======
import com.example.TelaLogin.User.User;
import com.example.TelaLogin.User.UserRepository;
import com.example.TelaLogin.User.UserResponseDTO;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class UserController
{

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService repo;

    /*@PostMapping(value = "/cadastro")
    public String saveUser(@RequestParam ("bairro") String bairro, @RequestParam ("cep") String cep,
                           @RequestParam ("cidade") String cidade,@RequestParam ("cnpj") String cnpj,
                           @RequestParam ("complemento") String complemento,@RequestParam ("email") String email,
                           @RequestParam ("inscricaoestadual") String inscricaoestadual, @RequestParam ("login") String login,
                           @RequestParam ("logotipog") String logotipog,@RequestParam ("logotipop") String logotipop,
                           @RequestParam ("nomeempresa") String nomeempresa,@RequestParam ("numero") String numero,
                           @RequestParam ("razaosocial") String razaosocial,@RequestParam ("rua") String rua,
                           @RequestParam ("senha") String senha,@RequestParam ("senhaconfirmada") String senhaconfirmada,
                           @RequestParam ("site") String site,@RequestParam ("uf") String uf)
    {
        User dados = new User(0,bairro,cep,cidade,cnpj,complemento,email,
                inscricaoestadual,login,logotipog,logotipop,nomeempresa,numero,razaosocial,rua,senha,senhaconfirmada,site,uf);
        repo.save(dados);
        return "Adicionado com sucesso";
    }*/

    @PostMapping(value = "/cadastro")
<<<<<<< Updated upstream

    public String saveUser(User dados,BindingResult result, RedirectAttributes redirect)
    {
        this.repo.save(dados);

        return "Adicionado com sucesso";
    }

    public String saveUser(@RequestBody User dados)
    {

        return "Cadastrou com Sucesso";

=======
    public String saveUser(User dados,BindingResult result, RedirectAttributes redirect)
    {

        return "Adicionado com sucesso";
>>>>>>> Stashed changes
    }

    @PostMapping(value = "/verificar-login")
    public String verificalogin(@RequestParam("login")String login,@RequestParam("senha")String senha)
    {
        List<UserResponseDTO> userlist = repository.findAll().stream().map(UserResponseDTO::new).toList();
        for(int i = 0; i< userlist.size();i++)
        {
            if(userlist.get(i).login().equals(login))
                return "Login bem sucedido";
        }
        return "Não existe Cadastro";
    }


    @GetMapping
    public List<UserResponseDTO> getall()
    {
        System.out.println("entrou aqui3");
        List<UserResponseDTO> userlist = repository.findAll().stream().map(UserResponseDTO::new).toList();

        return userlist;
    }


}



