package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    @Query(value="select * from exemplar " +
            "inner join titulo on exemplar.titulo_tit_id = titulo.tit_id" +
            " where lower(tit_nome) like %:chave%",nativeQuery = true)
    public List<Exemplar> findByChave(String chave);

    @Query(value="select * from exemplar inner join titulo on exemplar.titulo_tit_id = titulo.tit_id" +
            " where lower(tit_nome) like %:chave% and exe_data_entrada  BETWEEN :dataI AND :dataF",nativeQuery = true)
    public List<Exemplar> findByChave2(String chave, LocalDate dataI, LocalDate dataF);

    @Query(value="select * from exemplar" +
            " where exe_data_entrada  BETWEEN :dataI AND :dataF",nativeQuery = true)
    public List<Exemplar> findByChave3(LocalDate dataI, LocalDate dataF);
}
