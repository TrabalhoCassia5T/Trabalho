package com.example.UnoLibrary.Model.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "fisica")
public class Fisica {
    @Id
    @Column(name = "fis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fis_id;
    @Column(name = "fis_cpf")
    private String fis_cpf;
    @Column(name = "fis_data_nasc")
    private Date fis_data_nasc;
    @Column(name = "fis_est_civil")
    private String fis_est_civil;
    @Column(name = "fis_sexo")
    private String fis_sexo;
//    @ManyToOne
//    @JoinColumn(name="pes_id", nullable=false)
    @Column(name="pessoa_pes_id")
    private Long pessoa_pes_id;

    @OneToMany(mappedBy = "fisica")
    private List<Funcionario> funcionarios;

    public Fisica() {
    }

    public Fisica(Long fis_id, String fis_cpf, Date fis_data_nasc, String fis_estCivil, String fis_sexo, Long pessoa_pes_id) {
        this.fis_id = fis_id;
        this.fis_cpf = fis_cpf;
        this.fis_data_nasc = fis_data_nasc;
        this.fis_est_civil = fis_estCivil;
        this.fis_sexo = fis_sexo;
        this.pessoa_pes_id = pessoa_pes_id;
    }

    public Long getFis_id() {
        return fis_id;
    }

    public void setFis_id(Long fis_id) {
        this.fis_id = fis_id;
    }

    public String getFis_cpf() {
        return fis_cpf;
    }

    public void setFis_cpf(String fis_cpf) {
        this.fis_cpf = fis_cpf;
    }

    public Date getFis_dataNasc() {
        return fis_data_nasc;
    }

    public void setFis_dataNasc(Date fis_dataNasc) {
        this.fis_data_nasc = fis_dataNasc;
    }

    public String getFis_estCivil() {
        return fis_est_civil;
    }

    public void setFis_estCivil(String fis_estCivil) {
        this.fis_est_civil = fis_estCivil;
    }

    public String getFis_sexo() {
        return fis_sexo;
    }

    public void setFis_sexo(String fis_sexo) {
        this.fis_sexo = fis_sexo;
    }

    public Long getPessoa_pes_id() {
        return pessoa_pes_id;
    }

    public void setPessoa_pes_id(Long pessoa_pes_id) {
        pessoa_pes_id = pessoa_pes_id;
    }
}
