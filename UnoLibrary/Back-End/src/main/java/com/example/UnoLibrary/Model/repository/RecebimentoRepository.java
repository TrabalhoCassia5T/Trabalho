package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    @Query(value="select * from Recebimento where emprestimo_emp_id = :chave",nativeQuery = true)
    public Optional<Recebimento> findByEmpId(Long chave);
}
