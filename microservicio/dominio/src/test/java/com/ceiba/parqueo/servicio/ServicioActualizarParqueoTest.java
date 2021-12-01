package com.ceiba.parqueo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import com.ceiba.parqueo.servicio.testdatabuilder.ParqueoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarParqueoTest {

    private static final String EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA = "El parqueo no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa de un parqueo")
    void deberiaValidarLaExistenciaPreviaDeUnParqueo() {
        // arrange
        Parqueo parqueo = new ParqueoTestDataBuilder().conId(1L).build();
        RepositorioParqueo repositorioParqueo = Mockito.mock(RepositorioParqueo.class);
        Mockito.when(repositorioParqueo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarParqueo servicioActualizarParqueo = new ServicioActualizarParqueo(repositorioParqueo);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarParqueo.ejecutar(parqueo),
                ExcepcionDuplicidad.class,
                EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Parqueo parqueo = new ParqueoTestDataBuilder().conId(1L).build();
        RepositorioParqueo repositorioParqueo = Mockito.mock(RepositorioParqueo.class);
        Mockito.when(repositorioParqueo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarParqueo servicioActualizarParqueo = new ServicioActualizarParqueo(repositorioParqueo);

        // act
        servicioActualizarParqueo.ejecutar(parqueo);
        //assert
        Mockito.verify(repositorioParqueo, Mockito.times(1)).actualizar(parqueo);
    }
}