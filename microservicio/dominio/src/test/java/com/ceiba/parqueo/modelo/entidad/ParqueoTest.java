package com.ceiba.parqueo.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.parqueo.servicio.testdatabuilder.ParqueoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class ParqueoTest {

    private static final String DEBE_INGRESAR_LA_PLACA = "Debe ingresar la placa";
    private static final String DEBE_INGRESAR_EL_TIPO_DE_VEHICULO = "Debe ingresar el tipo de vehiculo";
    private static final String EL_TIPO_DE_VEHICULO_NO_ES_CORRECTO = "El tipo de vehiculo no es correcto";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INGRESO = "Debe especificar la fecha y hora de ingreso";
    private static final String LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_ACTUAL = "La fecha y hora de ingreso debe ser menor o igual a la fecha y hora actual";
    private static final String LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_SALIDA = "La fecha y hora de ingreso debe ser menor o igual a la fecha y hora de salida";

    @Test
    @DisplayName("Deberia crear un parqueo correctamente")
    void deberiaCrearUnParqueoCorrectamente() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conId(1L);

        // act
        Parqueo parqueo = parqueoTestDataBuilder.build();

        // assert
        assertEquals("GIX978", parqueo.getPlaca());
        assertEquals(String.valueOf(TipoVehiculo.AUTOMOVIL), parqueo.getTipoVehiculo());
        assertEquals(fechaIngreso, parqueo.getFechaHoraIngreso());
        assertNull(parqueo.getFechaHoraSalida());
        assertEquals(2000.0, parqueo.getValor());
        assertEquals("Sin direccionales", parqueo.getObservacion());
    }

    @Test
    @DisplayName("Deberia crear un parqueo correctamente")
    void deberiaCrearUnParqueoConSalidaCorrectamente() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        LocalDateTime fechaSalida = fechaIngreso.plusHours(2);
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conFechaHoraSalida(fechaSalida);

        // act
        Parqueo parqueo = parqueoTestDataBuilder.build();

        // assert
        assertEquals("GIX978", parqueo.getPlaca());
        assertEquals(String.valueOf(TipoVehiculo.AUTOMOVIL), parqueo.getTipoVehiculo());
        assertEquals(fechaIngreso, parqueo.getFechaHoraIngreso());
        assertEquals(fechaSalida, parqueo.getFechaHoraSalida());
        assertEquals(2000.0, parqueo.getValor());
        assertEquals("Sin direccionales", parqueo.getObservacion());
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo sin placa")
    void deberiaFallarLaCreacionDelParqueoSinPlaca() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conPlaca(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_LA_PLACA);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo por no especificar el tipo de vehiculo")
    void deberiaFallarLaCreacionDelParqueoPorNoEspecificarElTipoDeVehiculo() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conTipoVehiculo(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorObligatorio.class, DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo por tener un tipo de vehiculo no valido")
    void deberiaFallarLaCreacionDelParqueoPorTipoDeVehiculoNoValido() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conTipoVehiculo("MOTOCARGA");

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorInvalido.class, EL_TIPO_DE_VEHICULO_NO_ES_CORRECTO);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo por no especificar la fecha y hora de ingreso")
    void deberiaFallarLaCreacionDelParqueoPorNoEspecificarLaFechaYHoraDeIngreso() {
        // arrange
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder().conFechaHoraIngreso(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorObligatorio.class, DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INGRESO);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo por fecha y hora de ingreso mayor a la fecha hora actual")
    void deberiaFallarLaCreacionDelParqueoPorLaFechaYHoraDeIngresoMayorALaFechaHoraActual() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusDays(3);
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder().conFechaHoraIngreso(fechaIngreso);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorInvalido.class, LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_ACTUAL);
    }

    @Test
    @DisplayName("Deberia fallar la creacion de salida del parqueo por fecha y hora de ingreso mayor a la de salida")
    void deberiaFallarLaCreacionDeSalidaDelParqueoPorLaFechaYHoraDeIngresoMayorALaFechaDeSalida() {
        // arrange
        LocalDateTime fechaIngreso = LocalDateTime.now();
        LocalDateTime fechaSalida = fechaIngreso.minusHours(3);
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaIngreso)
                .conFechaHoraSalida(fechaSalida);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoTestDataBuilder::build,
                ExcepcionValorInvalido.class, LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_SALIDA);
    }
}