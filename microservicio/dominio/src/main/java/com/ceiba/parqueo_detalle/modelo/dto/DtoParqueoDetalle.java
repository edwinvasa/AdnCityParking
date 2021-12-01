package com.ceiba.parqueo_detalle.modelo.dto;

import java.time.LocalDateTime;

public class DtoParqueoDetalle {
    private Long id;
    private Long parqueoId;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Double valor;
    private Integer tarifaId;

    public DtoParqueoDetalle(Long id, Long parqueoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Double valor, Integer tarifaId) {
        this.id = id;
        this.parqueoId = parqueoId;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.valor = valor;
        this.tarifaId = tarifaId;
    }

    public Long getId() {
        return id;
    }

    public Long getParqueoId() {
        return parqueoId;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getTarifaId() {
        return tarifaId;
    }
}
