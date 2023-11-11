package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    @Query(value="select * from pessoa where upper(pes_nome) like %:nome%",nativeQuery = true)
    public List<Pessoa> findByNome(String nome);
}

