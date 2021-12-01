package com.ceiba.festivo.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Festivo {
    private final LocalDate fecha;
    private final String descripcion;

    public Festivo(LocalDate fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
