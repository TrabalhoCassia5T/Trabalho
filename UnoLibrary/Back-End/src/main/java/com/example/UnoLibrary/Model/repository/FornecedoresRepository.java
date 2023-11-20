package com.example.UnoLibrary.Model.repository;



import com.example.UnoLibrary.Model.entity.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>
{
    
}
