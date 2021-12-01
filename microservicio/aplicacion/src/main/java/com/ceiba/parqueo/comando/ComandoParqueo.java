package com.ceiba.parqueo.comando;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class ComandoParqueo {

    private Long id;
    private String placa;
    private String tipoVehiculo;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private Double valor;
    private String observacion;
}
