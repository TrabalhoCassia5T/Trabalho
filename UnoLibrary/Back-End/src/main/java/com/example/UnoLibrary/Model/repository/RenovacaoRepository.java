package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Renovacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RenovacaoRepository extends JpaRepository<Renovacao, Long> {

    @Query(value="select * from renovacao where emprestimo_exemplar_emprestimo_emp_id = :chave",nativeQuery = true)
    public Renovacao findByEmpId(Long chave);
}
