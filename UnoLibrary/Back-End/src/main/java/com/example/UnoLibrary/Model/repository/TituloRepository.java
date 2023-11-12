package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Autor;
import com.example.UnoLibrary.Model.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

}
