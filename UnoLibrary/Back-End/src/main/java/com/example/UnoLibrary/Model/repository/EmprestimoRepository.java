package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.OptionalInt;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query(value="select * from emprestimo where cliente_cli_id = :chave",nativeQuery = true)
    public Optional<Emprestimo> findByClienteId(Long chave);
}
