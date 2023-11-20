package com.example.UnoLibrary.Model.repository;



import com.example.UnoLibrary.Model.entity.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>
{
    // Método de pesquisa por parte do nome (ignorando maiúsculas e minúsculas)
    List<Fornecedores> findByNomeContainingIgnoreCase(String searchTerm);
}
