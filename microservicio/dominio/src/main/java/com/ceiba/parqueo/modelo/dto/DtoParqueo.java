package com.ceiba.parqueo.modelo.dto;

import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoParqueo {
    private Long id;
    private String placa;
    private TipoVehiculo tipoVehiculo;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private Double valor;
    private String observacion;

}
