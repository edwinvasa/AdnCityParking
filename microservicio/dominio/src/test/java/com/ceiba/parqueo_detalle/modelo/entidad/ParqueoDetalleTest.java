package com.ceiba.parqueo_detalle.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.parqueo_detalle.servicio.testdatabuilder.ParqueoDetalleTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParqueoDetalleTest {

    private static final String DEBE_INGRESAR_EL_PARQUEO = "Debe ingresar el parqueo";
    private static final String DEBE_INGRESAR_EL_TIPO_DE_TARIFA = "Debe ingresar el tipo de tarifa";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INICIO = "Debe especificar la fecha y hora de Inicio";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_FIN = "Debe especificar la fecha y hora de Fin";
    private static final String LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN = "La fecha y hora de inicio debe ser menor o igual a la fecha y hora fin";

    @Test
    @DisplayName("Deberia crear un parqueo detalle correctamente")
    void deberiaCrearUnParqueoDetalleCorrectamente() {
        // arrange
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.plusHours(5);
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conFechaHoraInicio(fechaInicio)
                .conFechaHoraFin(fechaFin);

        // act
        ParqueoDetalle parqueoDetalle = parqueoDetalleTestDataBuilder.build();

        // assert
        assertEquals(fechaInicio, parqueoDetalle.getFechaHoraInicio());
        assertEquals(fechaFin, parqueoDetalle.getFechaHoraFin());
        assertEquals(8000.0, parqueoDetalle.getValor());
        assertEquals(8, parqueoDetalle.getTarifaId());
        assertEquals(2L, parqueoDetalle.getParqueoId());
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo detalle sin especificar el parqueo")
    void deberiaFallarLaCreacionDelParqueoDetalleSinEstablecerElParqueo() {
        // arrange
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conParqueoId(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoDetalleTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_EL_PARQUEO);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo detalle sin especificar tipo de tarifa a aplicar")
    void deberiaFallarLaCreacionDelParqueoDetalleSinEspecificarLaTarifaAAplicar() {
        // arrange
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conTarifaId(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoDetalleTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_EL_TIPO_DE_TARIFA);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo detalle sin especificar la fecha hora de inicio")
    void deberiaFallarLaCreacionDelParqueoDetalleSinEspecificarLaFechaHoraHoraDeInicio() {
        // arrange
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conFechaHoraInicio(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoDetalleTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INICIO);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo detalle sin especificar la fecha hora de fin")
    void deberiaFallarLaCreacionDelParqueoDetalleSinEspecificarLaFechaHoraHoraDeFin() {
        // arrange
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conFechaHoraFin(null);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoDetalleTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_FIN);
    }

    @Test
    @DisplayName("Deberia fallar la creacion del parqueo detalle por fecha y hora de inicio mayor a la de fin")
    void deberiaFallarLaCreacionDelParqueoDetallePorLaFechaYHoraDeInicioMayorALaFechaDeFin() {
        // arrange
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.minusHours(3);
        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conFechaHoraInicio(fechaInicio)
                .conFechaHoraFin(fechaFin);

        // act - assert
        BasePrueba.assertThrows((BasePrueba.Thunk) parqueoDetalleTestDataBuilder::build,
                ExcepcionValorInvalido.class,
                LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN);
    }
}