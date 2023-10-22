package com.example.UnoLibrary.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findByCpf(String chave);
}
