package com.fisioclick.api.dto;

import java.io.Serializable;

public class ResponseUsuarioDTO implements Serializable {

    private String status;
    private String messageErro;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageErro() {
        return messageErro;
    }

    public void setMessageErro(String messageErro) {
        this.messageErro = messageErro;
    }
}
