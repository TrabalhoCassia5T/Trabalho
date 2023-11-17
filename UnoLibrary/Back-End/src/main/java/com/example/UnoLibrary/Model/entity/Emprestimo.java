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

    public Emprestimo() {
    }

    public Emprestimo(Long emp_id, Long cliente_cli_id, Date emp_data, Date emp_prev_devolucao, Long usuario_funcionario_func_id, String emp_status) {
        this.emp_id = emp_id;
        this.cliente_cli_id = cliente_cli_id;
        this.emp_data = emp_data;
        this.emp_prev_devolucao = emp_prev_devolucao;
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
        this.emp_status = emp_status;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public Long getCliente_cli_id() {
        return cliente_cli_id;
    }

    public void setCliente_cli_id(Long cliente_cli_id) {
        this.cliente_cli_id = cliente_cli_id;
    }

    public Date getEmp_data() {
        return emp_data;
    }

    public void setEmp_data(Date emp_data) {
        this.emp_data = emp_data;
    }

    public Date getEmp_prev_devolucao() {
        return emp_prev_devolucao;
    }

    public void setEmp_prev_devolucao(Date emp_prev_devolucao) {
        this.emp_prev_devolucao = emp_prev_devolucao;
    }

    public Long getUsuario_funcionario_func_id() {
        return usuario_funcionario_func_id;
    }

    public void setUsuario_funcionario_func_id(Long usuario_funcionario_func_id) {
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }
}
