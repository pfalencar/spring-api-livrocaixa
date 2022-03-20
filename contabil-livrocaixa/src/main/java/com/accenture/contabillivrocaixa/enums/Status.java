package com.accenture.contabillivrocaixa.enums;

public enum Status {

    ATIVO ("A"), CANCELADO("C");

    String status;

    Status(String string) {
        this.status = string;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
