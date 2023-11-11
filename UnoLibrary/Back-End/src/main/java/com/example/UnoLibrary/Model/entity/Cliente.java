package com.example.UnoLibrary.Model.entity;

import com.example.UnoLibrary.Model.repository.FisicaRepository;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "cli_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cli_id;
    @Column(name = "cli_data")
    private Date cli_data;
//    @ManyToOne
//    @JoinColumn(name="fis_id", nullable=false)
    @Column(name = "fisica_fis_id")
    private Long fisica_fis_id;


    public Cliente() {
    }

    public Cliente(Long cli_id, Date cli_data, Long fisica_fis_id) {
        this.cli_id = cli_id;
        this.cli_data = cli_data;
        this.fisica_fis_id = fisica_fis_id;
    }

    public Long getCli_id() {
        return cli_id;
    }

    public void setCli_id(Long cli_id) {
        this.cli_id = cli_id;
    }

    public Date getCli_data() {
        return cli_data;
    }

    public void setCli_data(Date cli_data) {
        this.cli_data = cli_data;
    }

    public Long getFisica_fis_id() {
        return fisica_fis_id;
    }

    public void setFisica_fis_id(Long fisica_fis_id) {
        fisica_fis_id = fisica_fis_id;
    }
}

