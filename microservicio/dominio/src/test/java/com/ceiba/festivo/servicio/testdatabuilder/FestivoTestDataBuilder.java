package com.ceiba.festivo.servicio.testdatabuilder;

import com.ceiba.festivo.modelo.entidad.Festivo;

import java.time.LocalDate;

public class FestivoTestDataBuilder {

    private LocalDate fecha;
    private String descripcion;

    public FestivoTestDataBuilder() {
        fecha = LocalDate.now();
        descripcion = "Dia Festivo";
    }

    public FestivoTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public FestivoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Festivo build() {
        return new Festivo(fecha, descripcion);
    }
}
