package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    @Query("SELECT u FROM Usuario u WHERE u.usu_login = :usu_login AND u.usu_senha = :usu_senha")
    Usuario findByUsuLoginAndUsuSenha(@Param("usu_login") String usu_login, @Param("usu_senha") String usu_senha);
}
