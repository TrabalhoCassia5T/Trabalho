package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Emprestimo_Exemplar")
public class EmprestimoExemplar {
    @Id
    @Column(name = "emprestimo_emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emprestimo_emp_id;

    @Column(name = "exemplar_exe_id")
    private Long exemplar_exe_id;

    @Column(name = "emp_data_dvlv")
    private Date emp_data_dvlv;

    public EmprestimoExemplar() {
    }

    public EmprestimoExemplar(Long emprestimo_emp_id, Long exemplar_exe_id, Date emp_data_dvlv) {
        this.emprestimo_emp_id = emprestimo_emp_id;
        this.exemplar_exe_id = exemplar_exe_id;
        this.emp_data_dvlv = emp_data_dvlv;
    }

    public Long getEmprestimo_emp_id() {
        return emprestimo_emp_id;
    }

    public void setEmprestimo_emp_id(Long emprestimo_emp_id) {
        this.emprestimo_emp_id = emprestimo_emp_id;
    }

    public Long getExemplar_exe_id() {
        return exemplar_exe_id;
    }

    public void setExemplar_exe_id(Long exemplar_exe_id) {
        this.exemplar_exe_id = exemplar_exe_id;
    }

    public Date getEmp_data_dvlv() {
        return emp_data_dvlv;
    }

    public void setEmp_data_dvlv(Date emp_data_dvlv) {
        this.emp_data_dvlv = emp_data_dvlv;
    }
}