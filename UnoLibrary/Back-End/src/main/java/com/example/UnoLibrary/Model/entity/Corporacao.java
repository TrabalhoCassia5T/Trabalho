package com.example.UnoLibrary.Model.entity;

import com.example.UnoLibrary.Model.DTOs.CorporacaoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "parametrizacao")
@Entity(name = "parametrizacao")
@Getter
@EqualsAndHashCode(of = "pam_id")
public class Corporacao
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pam_id")
    private  long pam_id;

    @Column(name = "pam_login")
    private String pam_login;

    @Column(name = "pam_nome_fantasia")
    private String pam_nome_fantasia;

    @Column(name = "pam_cnpj")
    private String pam_cnpj;

    @Column(name = "pam_razao_social")
    private String pam_razao_social;

    @Column(name = "pam_insc_estadual")
    private String pam_insc_estadual;

    @Column(name = "pam_email")
    private String pam_email;

    @Column(name = "pam_site")
    private String pam_site;

    @Column(name = "end_id")
    private Long  end_id;

    @Column(name = "pam_senha")
    private String pam_senha;

    @Column(name = "pam_logotipo_grande")
    private String pam_logotipo_grande;

    @Column(name = "pam_logotipo_peq")
    private String pam_logotipo_peq;

    public Corporacao() {
    }

    public Corporacao(long pam_id, String pam_login, String pam_nome_fantasia, String pam_cnpj, String pam_razao_social, String pam_insc_estadual,
                      String pam_email, String pam_site, Long end_id, String pam_senha, String pam_logotipo_grande, String pam_logotipo_peq) {
        this.pam_id = pam_id;
        this.pam_login = pam_login;
        this.pam_nome_fantasia = pam_nome_fantasia;
        this.pam_cnpj = pam_cnpj;
        this.pam_razao_social =  pam_razao_social;
        this.pam_insc_estadual = pam_insc_estadual;
        this.pam_email = pam_email;
        this.pam_site = pam_site;
        this.end_id = end_id;
        this.pam_senha = pam_senha;
        this.pam_logotipo_grande = pam_logotipo_grande;
        this.pam_logotipo_peq = pam_logotipo_peq;
    }

    public Corporacao(CorporacaoRequestDTO data)
    {
        this.pam_login = data.login();
        this.pam_nome_fantasia = data.nomeempresa();
        this.pam_cnpj = data.cnpj();
        this.pam_razao_social = data.razaosocial();
        this.pam_insc_estadual = data.inscricaoestadual();
        this.pam_email = data.email();
        this.pam_site = data.site();
        this.end_id = data.endId();
        this.pam_senha = data.senha();
        this.pam_logotipo_grande = data.logotipog();
        this.pam_logotipo_peq = data.logotipop();
    }

    public long getPam_id() {
        return pam_id;
    }

    public void setPam_id(long pam_id) {
        this.pam_id = pam_id;
    }

    public String getPam_login() {
        return pam_login;
    }

    public void setPam_login(String pam_login) {
        this.pam_login = pam_login;
    }

    public String getPam_nome_fantasia() {
        return pam_nome_fantasia;
    }

    public void setPam_nome_fantasia(String pam_nome_fantasia) {
        this.pam_nome_fantasia = pam_nome_fantasia;
    }

    public String getPam_cnpj() {
        return pam_cnpj;
    }

    public void setPam_cnpj(String pam_cnpj) {
        this.pam_cnpj = pam_cnpj;
    }

    public String getPam_razao_social() {
        return pam_razao_social;
    }

    public void setPam_razao_social(String pam_razao_social) {
        this.pam_razao_social = pam_razao_social;
    }

    public String getPam_insc_estadual() {
        return pam_insc_estadual;
    }

    public void setPam_insc_estadual(String pam_insc_estadual) {
        this.pam_insc_estadual = pam_insc_estadual;
    }

    public String getPam_email() {
        return pam_email;
    }

    public void setPam_email(String pam_email) {
        this.pam_email = pam_email;
    }

    public String getPam_site() {
        return pam_site;
    }

    public void setPam_site(String pam_site) {
        this.pam_site = pam_site;
    }

    public Long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(Long end_id) {
        this.end_id = end_id;
    }

    public String getPam_senha() {
        return pam_senha;
    }

    public void setPam_senha(String pam_senha) {
        this.pam_senha = pam_senha;
    }

    public String getPam_logotipo_grande() {
        return pam_logotipo_grande;
    }

    public void setPam_logotipo_grande(String pam_logotipo_grande) {
        this.pam_logotipo_grande = pam_logotipo_grande;
    }

    public String getPam_logotipo_peq() {
        return pam_logotipo_peq;
    }

    public void setPam_logotipo_peq(String pam_logotipo_peq) {
        this.pam_logotipo_peq = pam_logotipo_peq;
    }
}
