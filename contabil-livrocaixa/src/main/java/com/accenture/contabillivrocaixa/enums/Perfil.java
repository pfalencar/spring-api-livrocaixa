package com.accenture.contabillivrocaixa.enums;

public enum Perfil {

    ADMINISTRADOR("A"), OPERADOR("O");

    String perfil;

    Perfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
