package com.ceiba.tarifa.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTarifa {

    private Integer id;
    private String nombre;
    private String tipoVehiculo;
    private String tipoDia;
    private Double valor;
}
