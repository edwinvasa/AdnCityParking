package com.ceiba.tarifa.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.servicio.testdatabuilder.TarifaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifaTest {

    private static final String EL_VALOR_INGRESADO_DEBE_SER_MAYOR_A_CERO = "El valor ingresado debe ser mayor a cero";
    private static final String EL_TIPO_DE_VEHICULO_NO_EXISTE = "El tipo de vehiculo no existe";
    private static final String EL_TIPO_DE_DIA_NO_EXISTE = "El tipo de dia no existe";

    @Test
    @DisplayName("Deberia crear correctamente la tarifa")
    void deberiaCrearCorrectamenteLaTarifa() {
        // arrange
        String tipoDia = String.valueOf(TipoDia.DOMINGO);

        // act
        Tarifa tarifa = new TarifaTestDataBuilder().conTipoDia(tipoDia).build();

        //assert
        assertEquals(8, tarifa.getId());
        assertEquals("Domingo Automovil", tarifa.getNombre());
        assertEquals(TipoVehiculo.AUTOMOVIL, tarifa.getTipoVehiculo());
        assertEquals(TipoDia.DOMINGO, tarifa.getTipoDia());
        assertEquals(8000.0, tarifa.getValor());
    }

    @Test
    @DisplayName("Deberia fallar cuando el valor ingresado sea menor a cero")
    void deberiaFallarCuandoElValorIngresadoSeaMenorACero() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conValor(-5000.0);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) tarifaTestDataBuilder::build,
                ExcepcionValorInvalido.class,
                EL_VALOR_INGRESADO_DEBE_SER_MAYOR_A_CERO);
    }

    @Test
    @DisplayName("Deberia fallar cuando el tipo de vehiculo no existe")
    void deberiaFallarCuandoElTipoDeVehiculoNoExiste() {
        // arrange
        String tipoVehiculo = "MOTOCARGA";
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conTipoVehiculo(tipoVehiculo);

        // ACT - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) tarifaTestDataBuilder::build,
                ExcepcionValorInvalido.class,
                EL_TIPO_DE_VEHICULO_NO_EXISTE);
    }

    @Test
    @DisplayName("Deberia fallar cuando el tipo de dia no existe")
    void deberiaFallarCuandoElTipoDeDiaNoExiste() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conTipoDia("DIA LIBRE");

        // ACT - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) tarifaTestDataBuilder::build,
                ExcepcionValorInvalido.class,
                EL_TIPO_DE_DIA_NO_EXISTE);
    }

}