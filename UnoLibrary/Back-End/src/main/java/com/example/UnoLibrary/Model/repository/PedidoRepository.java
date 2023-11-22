package com.example.UnoLibrary.Model.repository;

import com.example.UnoLibrary.Model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>
{
}
