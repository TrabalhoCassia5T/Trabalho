package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="baixa")
public class Baixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="baix_id")
    private Long id;
    @Column(name="baix_motivo")
    private String motivo;
    @Column(name="baix_desc")
    private String desc;
    @Column(name="baix_data")
    private LocalDate data;
    @OneToOne()
    @JoinColumn(name = "exemplar_exe_id", referencedColumnName = "exe_id")
    private Exemplar exemplar;
    @ManyToOne()
    @JoinColumn(name="usuario_funcionario_func_id", nullable=false)
    private Usuario usuario;

    public Baixa() {
    }

    public Baixa(Long id, String motivo, String desc, LocalDate data, Exemplar exemplar, Usuario usuario) {
        this.id = id;
        this.motivo = motivo;
        this.desc = desc;
        this.data = data;
        this.exemplar = exemplar;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
