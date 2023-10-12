<<<<<<< HEAD
package com.example.TelaLogin.Controllers;

import com.example.TelaLogin.User.User;
import com.example.TelaLogin.User.UserRepository;
import com.example.TelaLogin.User.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
=======
package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.User.User;
import com.example.UnoLibrary.User.UserRepository;
import com.example.UnoLibrary.User.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> 54c8baa97fd34678135dbafd6f8cdbe293aa75c5

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class UserController
{

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/cadastro")
<<<<<<< HEAD
    public String saveUser(User dados,BindingResult result, RedirectAttributes redirect)
    {

        return "Adicionado com sucesso";
=======
    public String saveUser(@RequestBody User dados)
    {

        return "Cadastrou com Sucesso";
>>>>>>> 54c8baa97fd34678135dbafd6f8cdbe293aa75c5
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

