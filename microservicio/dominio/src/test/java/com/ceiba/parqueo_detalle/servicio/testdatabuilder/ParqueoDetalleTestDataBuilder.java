package com.ceiba.parqueo_detalle.servicio.testdatabuilder;

import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;

import java.time.LocalDateTime;

public class ParqueoDetalleTestDataBuilder {

    private Long id;
    private Long parqueoId;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Double valor;
    private Integer tarifaId;

    public ParqueoDetalleTestDataBuilder() {
        id = 1L;
        parqueoId = 2L;
        fechaHoraInicio = LocalDateTime.of(2021, 11, 29, 11, 15, 0);
        fechaHoraFin = LocalDateTime.of(2021, 11, 29, 13, 10, 0);
        valor = 8000.0;
        tarifaId = 8;
    }

    public ParqueoDetalleTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ParqueoDetalleTestDataBuilder conParqueoId(Long parqueoId) {
        this.parqueoId = parqueoId;
        return this;
    }

    public ParqueoDetalleTestDataBuilder conFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
        return this;
    }

    public ParqueoDetalleTestDataBuilder conFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
        return this;
    }

    public ParqueoDetalleTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ParqueoDetalleTestDataBuilder conTarifaId(Integer tarifaId) {
        this.tarifaId = tarifaId;
        return this;
    }

    public ParqueoDetalle build() {
        return new ParqueoDetalle(id, parqueoId, fechaHoraInicio, fechaHoraFin, valor, tarifaId);
    }

}
