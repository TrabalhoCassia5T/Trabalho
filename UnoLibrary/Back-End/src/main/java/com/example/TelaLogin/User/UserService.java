package com.example.TelaLogin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;
    public void save(User dados)
    {
        this.repository.save(dados);

    }
}
