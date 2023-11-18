package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Renovacao")
public class Renovacao {
    @Id
    @Column(name = "ren_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ren_id;
    @Column(name = "emprestimo_exemplar_emprestimo_emp_id")
    private Long emprestimo_exemplar_emprestimo_emp_id;
    @Column(name = "emprestimo_exemplar_exemplar_exe_id")
    private Long emprestimo_exemplar_exemplar_exe_id;
    @Column(name = "ren_data_prev_devolucao")
    private Date ren_data_prev_devolucao;
    @Column(name = "usuario_funcionario_func_id")
    private Long usuario_funcionario_func_id;

    public Renovacao() {
    }

    public Renovacao(Long ren_id, Long emprestimo_exemplar_emprestimo_emp_id, Long emprestimo_exemplar_exemplar_exe_id, Date ren_data_prev_devolucao, Long usuario_funcionario_func_id) {
        this.ren_id = ren_id;
        this.emprestimo_exemplar_emprestimo_emp_id = emprestimo_exemplar_emprestimo_emp_id;
        this.emprestimo_exemplar_exemplar_exe_id = emprestimo_exemplar_exemplar_exe_id;
        this.ren_data_prev_devolucao = ren_data_prev_devolucao;
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
    }

    public Long getRen_id() {
        return ren_id;
    }

    public void setRen_id(Long ren_id) {
        this.ren_id = ren_id;
    }

    public Long getEmprestimo_exemplar_emprestimo_emp_id() {
        return emprestimo_exemplar_emprestimo_emp_id;
    }

    public void setEmprestimo_exemplar_emprestimo_emp_id(Long emprestimo_exemplar_emprestimo_emp_id) {
        this.emprestimo_exemplar_emprestimo_emp_id = emprestimo_exemplar_emprestimo_emp_id;
    }

    public Long getEmprestimo_exemplar_exemplar_exe_id() {
        return emprestimo_exemplar_exemplar_exe_id;
    }

    public void setEmprestimo_exemplar_exemplar_exe_id(Long emprestimo_exemplar_exemplar_exe_id) {
        this.emprestimo_exemplar_exemplar_exe_id = emprestimo_exemplar_exemplar_exe_id;
    }

    public Date getRen_data_prev_devolucao() {
        return ren_data_prev_devolucao;
    }

    public void setRen_data_prev_devolucao(Date ren_data_prev_devolucao) {
        this.ren_data_prev_devolucao = ren_data_prev_devolucao;
    }

    public Long getUsuario_funcionario_func_id() {
        return usuario_funcionario_func_id;
    }

    public void setUsuario_funcionario_func_id(Long usuario_funcionario_func_id) {
        this.usuario_funcionario_func_id = usuario_funcionario_func_id;
    }
}