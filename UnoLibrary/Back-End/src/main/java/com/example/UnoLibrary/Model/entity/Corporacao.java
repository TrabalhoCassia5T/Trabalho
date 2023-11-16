package com.example.UnoLibrary.Model.entity;

import com.example.UnoLibrary.Model.DTOs.CorporacaoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "empresas")
@Entity(name = "empresas")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Corporacao
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String login;
    private String nomeempresa;
    private String cnpj;
    private String razaosocial;
    private String inscricaoestadual;
    private String email;
    private String site;
    private Long   end_id;
    private String senha;
    private String logotipog;
    private String logotipop;

    public Corporacao(long id, String login, String nomeempresa, String cnpj, String razaosocial, String inscricaoestadual, String email, String site, Long end_id, String senha, String logotipog, String logotipop) {
        this.id = id;
        this.login = login;
        this.nomeempresa = nomeempresa;
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
        this.inscricaoestadual = inscricaoestadual;
        this.email = email;
        this.site = site;
        this.end_id = end_id;
        this.senha = senha;
        this.logotipog = logotipog;
        this.logotipop = logotipop;
    }

    public Corporacao(CorporacaoRequestDTO data)
    {
        this.login = data.login();
        this.nomeempresa = data.nomeempresa();
        this.cnpj = data.cnpj();
        this.razaosocial = data.razaosocial();
        this.inscricaoestadual = data.inscricaoestadual();
        this.email = data.email();
        this.site = data.site();
        this.end_id = data.endId();
        this.senha = data.senha();
        this.logotipog = data.logotipog();
        this.logotipop = data.logotipop();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeempresa() {
        return nomeempresa;
    }

    public void setNomeempresa(String nomeempresa) {
        this.nomeempresa = nomeempresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setEndId(Long id) {
        this.end_id = id;
    }

    public Long getEndId() {
        return end_id;
    }
   
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogotipog() {
        return logotipog;
    }

    public void setLogotipog(String logotipog) {
        this.logotipog = logotipog;
    }

    public String getLogotipop() {
        return logotipop;
    }

    public void setLogotipop(String logotipop) {
        this.logotipop = logotipop;
    }
}
