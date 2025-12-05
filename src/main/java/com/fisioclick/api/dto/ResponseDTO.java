package com.fisioclick.api.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

    private String status;
    private String mensagem;
    private Object object;

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
