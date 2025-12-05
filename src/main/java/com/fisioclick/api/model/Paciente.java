package com.fisioclick.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String idade;

    private String nome;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentoList;

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
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
