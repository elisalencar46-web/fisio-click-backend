package com.fisioclick.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "fisioterapeuta")
public class Fisioterapeuta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFisioterapeuta;

    private String inscricao;

    private String especialida;

    private String nome;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "fisioterapeuta")
    private List<Agendamento> agendamentoList;

    public Long getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(Long idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getEspecialida() {
        return especialida;
    }

    public void setEspecialida(String especialida) {
        this.especialida = especialida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Agendamento> getAgendamentoList() {
        return agendamentoList;
    }

    public void setAgendamentoList(List<Agendamento> agendamentoList) {
        this.agendamentoList = agendamentoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
