package com.accenture.contabillivrocaixa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import com.accenture.contabillivrocaixa.enums.Perfil;
import com.accenture.contabillivrocaixa.enums.Status;


@Entity
@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable=false)
    private BigInteger id;

    @NotNull
    @Column(nullable=false)
    //@timezone ...
    private Date dataCadastro;

    @NotBlank
    @NotNull
    @Column(nullable=false)
    private String nome;

    @NotBlank
    @NotNull
    @Column(nullable=false, unique = true)
    private String login;

    @NotBlank
    @NotNull
    @Column(nullable=false)
    private String senha;

    @Column(nullable=false)
    private String telefone;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
