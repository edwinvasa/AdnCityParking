package com.ceiba.festivo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFestivo {
    private LocalDate fecha;
    private String descripcion;
}
