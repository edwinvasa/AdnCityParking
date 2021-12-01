package com.ceiba.parqueo_detalle.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;
import com.ceiba.parqueo_detalle.puerto.repositorio.RepositorioParqueoDetalle;
import com.ceiba.parqueo_detalle.servicio.testdatabuilder.ParqueoDetalleTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearParqueoDetalleTest {

    private static final String LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN = "La fecha y hora de inicio debe ser menor o igual a la fecha y hora fin";

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha hora fin es menor a la fecha hora inicio")
    void deberiaLanzarUnaExepcionCuandoLaFechaYHoraFinEsMenorALaFechaHoraInicio() {
        // arrange
        LocalDateTime fechaHoraInicio = LocalDateTime.of(2021, 11, 29, 11, 15, 0);
        LocalDateTime fechaHoraFin = LocalDateTime.of(2021, 11, 25, 13, 10, 0);

        ParqueoDetalleTestDataBuilder parqueoDetalleTestDataBuilder = new ParqueoDetalleTestDataBuilder()
                .conFechaHoraInicio(fechaHoraInicio)
                .conFechaHoraFin(fechaHoraFin);

        // act - assert
        BasePrueba.assertThrows(parqueoDetalleTestDataBuilder::build,
                ExcepcionValorInvalido.class,
                LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        ParqueoDetalle parqueoDetalle = new ParqueoDetalleTestDataBuilder().build();

        RepositorioParqueoDetalle repositorioParqueoDetalle = Mockito.mock(RepositorioParqueoDetalle.class);
        Mockito.when(repositorioParqueoDetalle.crear(parqueoDetalle)).thenReturn(10L);
        ServicioCrearParqueoDetalle servicioCrearParqueoDetalle = new ServicioCrearParqueoDetalle(repositorioParqueoDetalle);

        // act
        Long idParqueoDetalle = servicioCrearParqueoDetalle.ejecutar(parqueoDetalle);

        //- assert
        assertEquals(10L, idParqueoDetalle);
        Mockito.verify(repositorioParqueoDetalle, Mockito.times(1)).crear(parqueoDetalle);
    }

}