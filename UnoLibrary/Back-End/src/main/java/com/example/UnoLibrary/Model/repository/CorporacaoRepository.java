package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Corporacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Corporacao, Long>
{

}
