package com.ceiba.tarifa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.TarifaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarTarifaTest {

    private static final String LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA = "La tarifa no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa de una tarifa")
    void deberiaValidarLaExistenciaPreviaDeUnaTarifa() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().conId(8).build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existePorId(Mockito.anyInt())).thenReturn(false);
        ServicioActualizarTarifa servicioActualizarTarifa = new ServicioActualizarTarifa(repositorioTarifa);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTarifa.ejecutar(tarifa),
                ExcepcionDuplicidad.class,
                LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().conId(8).build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existePorId(Mockito.anyInt())).thenReturn(true);
        ServicioActualizarTarifa servicioActualizarTarifa = new ServicioActualizarTarifa(repositorioTarifa);

        // act
        servicioActualizarTarifa.ejecutar(tarifa);

        //assert
        Mockito.verify(repositorioTarifa, Mockito.times(1)).actualizar(tarifa);
    }

}