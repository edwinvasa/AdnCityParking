package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoParqueo {

    private Integer id;
    private String placa;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;

}
