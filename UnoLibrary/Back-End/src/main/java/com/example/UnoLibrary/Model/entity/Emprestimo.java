package com.example.UnoLibrary.Model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    @Column(name = "cliente_cli_id")
    private Long cliente_cli_id;

    @Column(name = "emp_data")
    private Date emp_data;

    @Column(name = "emp_prev_devolucao")
    private Date emp_prev_devolucao;

    @Column(name = "usuario_funcionario_func_id")
    private Long usuario_funcionario_func_id;

    @Column(name = "emp_status")
    private String emp_status;

    

}
