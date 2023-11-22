package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_func_id")
    private Long id;
    @Column(name = "usu_login")
    private String usu_login;

    @Column(name = "usu_senha")
    private String usu_senha;

    @Column(name = "usu_data_perm")
    private LocalDate usu_data_perm;

    @Column(name = "usu_data_desativa")
    private LocalDate usu_data_desativa;

    @Column(name = "usu_nivel")
    private String usu_nivel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_func_id", referencedColumnName = "func_id")
    private Funcionario funcionario;

    public Usuario() {
    }

    public Usuario(Long id, String usu_login, String usu_senha, LocalDate usu_data_perm, LocalDate usu_data_desativa, String usu_nivel, Funcionario funcionario) {
        this.id = id;
        this.usu_login = usu_login;
        this.usu_senha = usu_senha;
        this.usu_data_perm = usu_data_perm;
        this.usu_data_desativa = usu_data_desativa;
        this.usu_nivel = usu_nivel;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public LocalDate getUsu_data_perm() {
        return usu_data_perm;
    }

    public void setUsu_data_perm(LocalDate usu_data_perm) {
        this.usu_data_perm = usu_data_perm;
    }

    public LocalDate getUsu_data_desativa() {
        return usu_data_desativa;
    }

    public void setUsu_data_desativa(LocalDate usu_data_desativa) {
        this.usu_data_desativa = usu_data_desativa;
    }

    public String getUsu_nivel() {
        return usu_nivel;
    }

    public void setUsu_nivel(String usu_nivel) {
        this.usu_nivel = usu_nivel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
