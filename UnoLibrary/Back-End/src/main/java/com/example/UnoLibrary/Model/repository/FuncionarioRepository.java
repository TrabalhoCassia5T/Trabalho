package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
