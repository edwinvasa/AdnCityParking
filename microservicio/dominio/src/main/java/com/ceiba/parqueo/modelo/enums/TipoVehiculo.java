package com.ceiba.parqueo.modelo.enums;

public enum TipoVehiculo {
    AUTOMOVIL("AUTOMOVIL"), MOTOCICLETA("MOTOCICLETA");

    private String nombre;

    TipoVehiculo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
