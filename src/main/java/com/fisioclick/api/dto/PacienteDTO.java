package com.fisioclick.api.dto;

import java.io.Serializable;

public class PacienteDTO implements Serializable {

    private String idade;
    private String nome;
    private UsuarioDTO usuarioDTO;

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
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
}
