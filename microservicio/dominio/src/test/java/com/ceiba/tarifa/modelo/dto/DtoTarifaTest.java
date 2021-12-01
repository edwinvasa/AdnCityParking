package com.ceiba.tarifa.modelo.dto;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.servicio.testdatabuilder.DtoTarifaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoTarifaTest {

    @Test
    @DisplayName("Deberia crear correctamente el Dto tarifa")
    void deberiaCrearCorrectamenteElDtoTarifa() {
        // Preparación
        TipoVehiculo tipoVehiculo = TipoVehiculo.AUTOMOVIL;
        TipoDia tipoDia = TipoDia.FESTIVO;

        // Ejecución
        DtoTarifa dtoTarifa = new DtoTarifaTestDataBuilder()
                .conTipoVehiculo(tipoVehiculo)
                .conTipoDia(tipoDia)
                .build();
        // Assert
        assertEquals(tipoVehiculo, dtoTarifa.getTipoVehiculo());
        assertEquals(tipoDia, dtoTarifa.getTipoDia());
        assertEquals(8000.0, dtoTarifa.getValor());
    }
}