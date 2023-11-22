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
    private String func_cargo;

    @OneToOne(mappedBy = "funcionario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fisica_fis_id", referencedColumnName = "fis_id")
    private Fisica fisica;

    public Funcionario() {
    }

    public Funcionario(Long func_id, String func_cargo, Fisica fisica) {
        this.func_id = func_id;
        this.func_cargo = func_cargo;
        this.fisica = fisica;
    }

    public Long getFunc_id() {
        return func_id;
    }

    public void setFunc_id(Long func_id) {
        this.func_id = func_id;
    }

    public String getFunc_cargo() {
        return func_cargo;
    }

    public void setFunc_cargo(String func_cargo) {
        this.func_cargo = func_cargo;
    }

    public Fisica getFisica() {
        return fisica;
    }

    public void setFisica(Fisica fisica) {
        this.fisica = fisica;
    }
}
