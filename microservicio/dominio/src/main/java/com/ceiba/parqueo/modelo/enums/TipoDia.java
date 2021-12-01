package com.ceiba.parqueo.modelo.enums;

public enum TipoDia {
    FESTIVO("FESTIVO"), DOMINGO("DOMINGO"), SABADO("SABADO"), REGULAR("REGULAR");

    String nombre;

    TipoDia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
