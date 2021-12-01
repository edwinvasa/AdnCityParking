package com.ceiba.parqueo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import com.ceiba.parqueo.servicio.testdatabuilder.ParqueoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearParqueoTest {

    private static final String EL_PARQUEO_YA_EXISTE = "El parqueo ya existe";

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del parqueo")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Parqueo parqueo = new ParqueoTestDataBuilder().build();
        RepositorioParqueo repositorioParqueo = Mockito.mock(RepositorioParqueo.class);
        Mockito.when(repositorioParqueo.existe(Mockito.anyString(), Mockito.any())).thenReturn(true);
        ServicioCrearParqueo servicioCrearParqueo = new ServicioCrearParqueo(repositorioParqueo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearParqueo.ejecutar(parqueo),
                ExcepcionDuplicidad.class,
                EL_PARQUEO_YA_EXISTE);
    }

    @Test
    @DisplayName("Deberia Crear el parqueo de manera correcta")
    void deberiaCrearElParqueoDeManeraCorrecta() {
        // arrange
        Parqueo parqueo = new ParqueoTestDataBuilder().build();
        RepositorioParqueo repositorioParqueo = Mockito.mock(RepositorioParqueo.class);
        Mockito.when(repositorioParqueo.existe(Mockito.anyString(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioParqueo.crear(parqueo)).thenReturn(10L);
        ServicioCrearParqueo servicioCrearParqueo = new ServicioCrearParqueo(repositorioParqueo);
        // act
        Long idParqueo = servicioCrearParqueo.ejecutar(parqueo);
        //- assert
        assertEquals(10L, idParqueo);
        Mockito.verify(repositorioParqueo, Mockito.times(1)).crear(parqueo);
    }
}