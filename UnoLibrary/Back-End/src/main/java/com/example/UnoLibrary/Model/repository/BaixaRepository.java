package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Baixa;
import com.example.UnoLibrary.Model.entity.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BaixaRepository extends JpaRepository<Baixa, Long> {
    @Query(value="select * from baixa" +
            " where baix_motivo = :chave",nativeQuery = true)
    public List<Baixa> findByChave(String chave);

    @Query(value="select * from baixa" +
            " where baix_motivo = :chave and baix_data  BETWEEN :dataI AND :dataF",nativeQuery = true)
    public List<Baixa> findByChave2(String chave, LocalDate dataI, LocalDate dataF);

    @Query(value="select * from baixa" +
            " where baix_data  BETWEEN :dataI AND :dataF",nativeQuery = true)
    public List<Baixa> findByChave3(LocalDate dataI, LocalDate dataF);

    @Query(value = "select * from baixa where exemplar_exe_id = :id_exe", nativeQuery = true)
    public Baixa findByExemplar(Long id_exe);
}
