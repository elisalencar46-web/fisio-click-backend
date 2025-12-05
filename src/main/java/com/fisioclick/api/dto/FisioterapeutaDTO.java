package com.fisioclick.api.dto;

import java.io.Serializable;

public class FisioterapeutaDTO implements Serializable {

    private String id;
    private String inscricao;
    private String nome;
    private UsuarioDTO usuarioDTO;

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
