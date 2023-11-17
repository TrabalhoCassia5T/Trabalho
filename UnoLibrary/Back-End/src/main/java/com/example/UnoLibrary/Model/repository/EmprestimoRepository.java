package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
