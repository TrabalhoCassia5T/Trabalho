package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FisicaRepository extends JpaRepository<Fisica, Long> {
    @Query(value="select * from fisica where fis_cpf like %:chave%",nativeQuery = true)
    public List<Fisica> findByCpf(String chave);

    @Query(value="select * from fisica where pessoa_pes_id = :chave",nativeQuery = true)
    public Fisica findByPessoaId(Long chave);
}
