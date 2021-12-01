package com.ceiba.tarifa.modelo.dto;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTarifa {
    private Integer id;
    private String nombre;
    private TipoVehiculo tipoVehiculo;
    private TipoDia tipoDia;
    private Double valor;
}
