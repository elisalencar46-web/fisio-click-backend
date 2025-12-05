package com.fisioclick.api.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseListDTO implements Serializable {

    private String status;
    private String mensagem;
    private List<Object> object;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Object> getObject() {
        return object;
    }

    public void setObject(List<Object> object) {
        this.object = object;
    }
}
