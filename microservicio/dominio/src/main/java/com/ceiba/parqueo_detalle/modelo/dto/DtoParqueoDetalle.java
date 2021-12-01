package com.ceiba.parqueo_detalle.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoParqueoDetalle {
    private Long id;
    private Long parqueoId;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Double valor;
    private Integer tarifaId;
}
