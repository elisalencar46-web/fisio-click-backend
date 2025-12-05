package com.fisioclick.api.dto;

import java.io.Serializable;

public class ResponseAgendamentoDto implements Serializable {

    private String idAgendamento;
    private String nomePaciente;
    private String nomeFisioterapeuta;
    private String inscricao;
    private String dataAgendamento;
    private String horaAgendamento;
    private String status;

    public String getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(String idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeFisioterapeuta() {
        return nomeFisioterapeuta;
    }

    public void setNomeFisioterapeuta(String nomeFisioterapeuta) {
        this.nomeFisioterapeuta = nomeFisioterapeuta;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(String horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
}
