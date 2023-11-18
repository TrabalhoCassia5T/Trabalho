package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Recebimento")
public class Recebimento {
    @Id
    @Column(name = "rec_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rec_id;
    @Column(name = "rec_valor")
    private double rec_valor;
    @Column(name = "rec_data")
    private Date rec_data;
    @Column(name = "emprestimo_emp_id")
    private Long emprestimo_emp_id;
    @Column(name = "usuario_funcionario_func_id")
    private Long usuario_funcionario_func_id;

    public Recebimento() {
    }

    public Recebimento(Long rec_id, double rec_valor, Date rec_data, Long emprestimo_emp_id, Long usuario_funcionario_func_id) {
        this.rec_id = rec_id;
        this.rec_valor = rec_valor;
        this.rec_data = rec_data;
        this.emprestimo_emp_id = emprestimo_emp_id;
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
    }

    public Long getRec_id() {
        return rec_id;
    }

    public void setRec_id(Long rec_id) {
        this.rec_id = rec_id;
    }

    public double getRec_valor() {
        return rec_valor;
    }

    public void setRec_valor(double rec_valor) {
        this.rec_valor = rec_valor;
    }

    public Date getRec_data() {
        return rec_data;
    }

    public void setRec_data(Date rec_data) {
        this.rec_data = rec_data;
    }

    public Long getEmprestimo_emp_id() {
        return emprestimo_emp_id;
    }

    public void setEmprestimo_emp_id(Long emprestimo_emp_id) {
        this.emprestimo_emp_id = emprestimo_emp_id;
    }

    public Long getUsuario_funcionario_func_id() {
        return usuario_funcionario_func_id;
    }

    public void setUsuario_funcionario_func_id(Long usuario_funcionario_func_id) {
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
    }
}
