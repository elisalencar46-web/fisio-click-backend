package com.fisioclick.api.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private String id;
    private String cpf;
    private String senha;
    private String tipoUsuario;
    private boolean autenticado;

    public UsuarioDTO(String id, String cpf, String senha, String tipoUsuario) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDTO(String id, String cpf, String tipoUsuario, boolean autenticado) {
        this.id = id;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
        this.autenticado = autenticado;
    }

    public UsuarioDTO() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
