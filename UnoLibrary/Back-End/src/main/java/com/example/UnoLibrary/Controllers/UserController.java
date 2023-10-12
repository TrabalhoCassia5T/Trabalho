package com.example.UnoLibrary.Controllers;

import com.example.UnoLibrary.User.User;
import com.example.UnoLibrary.User.UserRepository;
import com.example.UnoLibrary.User.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class UserController
{

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/cadastro")
    public String saveUser(@RequestBody User dados)
    {

        return "Cadastrou com Sucesso";
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


