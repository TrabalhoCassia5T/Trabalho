package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
}
