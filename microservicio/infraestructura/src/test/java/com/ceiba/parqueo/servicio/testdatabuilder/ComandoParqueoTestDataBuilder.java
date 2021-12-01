package com.ceiba.parqueo.servicio.testdatabuilder;

import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;

import java.time.LocalDateTime;

public class ComandoParqueoTestDataBuilder {

    private Long id;
    private String placa;
    private String tipoVehiculo;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private Double valor;
    private String observacion;

    public ComandoParqueoTestDataBuilder() {
        id = 2L;
        placa = "ABC123";
        tipoVehiculo = String.valueOf(TipoVehiculo.AUTOMOVIL);
        fechaHoraIngreso = LocalDateTime.of(2021, 11, 29, 11, 15, 0);
        valor = 0.0;
        observacion = "Sin observacion";
    }

    public ComandoParqueoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoParqueoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoParqueoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ComandoParqueoTestDataBuilder conFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
        return this;
    }

    public ComandoParqueoTestDataBuilder conFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
        return this;
    }

    public ComandoParqueoTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoParqueoTestDataBuilder conObservacion(String observacion) {
        this.observacion = observacion;
        return this;
    }

    public ComandoParqueo build() {
        return new ComandoParqueo(id, placa, tipoVehiculo, fechaHoraIngreso, fechaHoraSalida, valor, observacion);
    }
}
