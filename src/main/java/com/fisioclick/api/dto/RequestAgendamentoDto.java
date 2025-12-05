package com.fisioclick.api.dto;

import java.io.Serializable;

public class RequestAgendamentoDto implements Serializable {

    private String idUsuario;
    private String idFisioterapeuta;
    private String dataAgendamento;
    private String horaAgendamento;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(String idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }
}
