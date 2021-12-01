package com.ceiba.festivo.modelo.entidad;

import java.time.LocalDate;

public class Festivo {
    private final LocalDate fecha;
    private final String descripcion;

    public Festivo(LocalDate fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
