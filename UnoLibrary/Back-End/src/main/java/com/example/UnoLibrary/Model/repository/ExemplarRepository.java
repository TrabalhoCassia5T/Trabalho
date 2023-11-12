package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Exemplar;
import com.example.UnoLibrary.Model.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}
