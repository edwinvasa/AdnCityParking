package com.ceiba.parqueo.servicio.testdatabuilder;

import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;

import java.time.LocalDateTime;

public class ParqueoTestDataBuilder {

    private Long id;
    private String placa;
    private String tipoVehiculo;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private Double valor;
    private String observacion;

    public ParqueoTestDataBuilder() {
        id = 2L;
        placa = "GIX978";
        tipoVehiculo = String.valueOf(TipoVehiculo.AUTOMOVIL);
        fechaHoraIngreso = LocalDateTime.of(2021, 11, 29, 11, 15, 0);
        valor = 2000.0;
        observacion = "Sin direccionales";
    }

    public ParqueoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ParqueoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ParqueoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ParqueoTestDataBuilder conFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
        return this;
    }

    public ParqueoTestDataBuilder conFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
        return this;
    }

    public ParqueoTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ParqueoTestDataBuilder conObservacion(String observacion) {
        this.observacion = observacion;
        return this;
    }

    public Parqueo build() {
        return new Parqueo(id, placa, tipoVehiculo, fechaHoraIngreso, fechaHoraSalida, valor, observacion);
    }
}
