package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "func_id")
    private Long func_id;

    @Column(name = "func_cargo")
    private Long func_cargo;

    @Column(name = "fisica_fis_id")
    private Long fisica_fis_id;

    @ManyToOne
    @JoinColumn(name = "fisica", referencedColumnName = "fisica_fis_id")
    private Funcionario funcionario;

    public Funcionario() {
    }

    public Funcionario(Long func_id, Long func_cargo, Funcionario funcionario) {
        this.func_id = func_id;
        this.func_cargo = func_cargo;
        this.funcionario = funcionario;
    }

    public Long getFunc_id() {
        return func_id;
    }

    public void setFunc_id(Long func_id) {
        this.func_id = func_id;
    }

    public Long getFunc_cargo() {
        return func_cargo;
    }

    public void setFunc_cargo(Long func_cargo) {
        this.func_cargo = func_cargo;
    }

    public Long getFisica_fis_id() {
        return fisica_fis_id;
    }

    public void setFisica_fis_id(Long fisica_fis_id) {
        this.fisica_fis_id = fisica_fis_id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
