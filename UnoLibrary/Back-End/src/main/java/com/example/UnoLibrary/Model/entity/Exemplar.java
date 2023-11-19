package com.example.UnoLibrary.Model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="exemplar")
public class Exemplar {
    @Id
    @Column(name="exe_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name="exe_status")
    private String status;
    @Column(name="exe_data_entrada")
    private LocalDate dataEntrada;
    @ManyToOne()
    @JoinColumn(name="titulo_tit_id")
    private Titulo titulo;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "exemplar")
    private Baixa baixa;

    public Exemplar(Long id, String status, LocalDate dataEntrada, Titulo titulo) {
        this.id = id;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.titulo = titulo;
    }

    public Exemplar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
}
