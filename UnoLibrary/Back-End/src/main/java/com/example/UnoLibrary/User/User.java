package com.example.UnoLibrary.User;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "empresas")
@Entity(name = "empresas")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User
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
    private String cep;
    private String cidade;
    private String uf;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String senha;
    private String senhaconfirmada;
    private String logotipog;
    private String logotipop;

    public User (UserRequestDTO data)
    {
        this.login = data.login();
        this.nomeempresa = data.nomeempresa();
        this.cnpj = data.cnpj();
        this.razaosocial = data.razaosocial();
        this.inscricaoestadual = data.inscricaoestadual();
        this.email = data.email();
        this.site = data.site();
        this.cep = data.cep();
        this.cidade = data.cidade();
        this.uf = data.uf();
        this.rua = data.rua();
        this.bairro = data.bairro();
        this.numero = data.numero();
        this.complemento = data.complemento();
        this.senha = data.senha();
        this.senhaconfirmada = data.senhaconfirmada();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaconfirmada() {
        return senhaconfirmada;
    }

    public void setSenhaconfirmada(String senhaconfirmada) {
        this.senhaconfirmada = senhaconfirmada;
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
