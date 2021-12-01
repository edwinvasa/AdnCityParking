package com.ceiba.festivo.modelo.entidad;

import com.ceiba.festivo.servicio.testdatabuilder.FestivoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FestivoTest {

    @Test
    @DisplayName("Debería crear correctamente el festivo")
    void DeberiaCrearCorrectamenteElFestivo() {
        // arrange
        LocalDate fecha = LocalDate.of(2022, 1, 1);
        String descripcion = "Año Nuevo";

        // act
        Festivo festivo = new FestivoTestDataBuilder()
                .conFecha(fecha)
                .conDescripcion(descripcion)
                .build();

        // assert
        assertEquals(fecha, festivo.getFecha());
        assertEquals(descripcion, festivo.getDescripcion());
    }

}