package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Cliente;
import com.example.UnoLibrary.Model.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long>
{
    @Query(value="select * from titulo where lower(tit_nome) like %:chave%",nativeQuery = true)
    public List<Titulo> findByTitulo(String chave);
}
