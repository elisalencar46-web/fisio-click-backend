package com.fisioclick.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;

    private LocalDate dataAgendamento;

    private char status;

    private String hora;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_fisioterapeuta")
    private Fisioterapeuta fisioterapeuta;

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Fisioterapeuta getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
