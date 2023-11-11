package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Cliente;
import com.example.UnoLibrary.Model.entity.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
    @Query(value="select * from cliente where fisica_fis_id = :chave",nativeQuery = true)
    public Cliente findByFisicaId(Long chave);
}
