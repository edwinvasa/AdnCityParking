package com.ceiba.parqueo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.festivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import com.ceiba.parqueo.servicio.testdatabuilder.ParqueoTestDataBuilder;
import com.ceiba.parqueo_detalle.servicio.ServicioCrearParqueoDetalle;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.DtoTarifaTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicioRegistrarSalidaParqueoTest {

    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_SALIDA = "Debe especificar la fecha y hora de salida";

    private RepositorioParqueo repositorioParqueo;
    private RepositorioFestivo repositorioFestivo;
    private DaoTarifa daoTarifa;
    private ServicioCrearParqueoDetalle servicioCrearParqueoDetalle;

    @BeforeAll
    public void setUp() {
        repositorioParqueo = Mockito.mock(RepositorioParqueo.class);
        repositorioFestivo = Mockito.mock(RepositorioFestivo.class);
        daoTarifa = Mockito.mock(DaoTarifa.class);
        servicioCrearParqueoDetalle = Mockito.mock(ServicioCrearParqueoDetalle.class);
    }

    @Test
    @DisplayName("Deberia registrar la salida del parqueo correctamente con igual fecha de ingreso y salida y dia festivo")
    void deberiaRegistrarLaSalidaDelParqueoCorectamenteConIgualFechaDeIngresoYSalidaYDiaFestivo() {
        // Arrange
        LocalDateTime fechaHoraIngreso = LocalDateTime.of(2021, 11, 30, 11, 15, 00);
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2021, 11, 30, 13, 10, 00);

        Parqueo parqueo = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaHoraIngreso)
                .conFechaHoraSalida(fechaHoraSalida)
                .build();

        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(parqueo.getTipoVehiculo());
        TipoDia tipoDia = TipoDia.FESTIVO;

        DtoTarifa dtoTarifa = new DtoTarifaTestDataBuilder()
                .conId(8)
                .conTipoDia(tipoDia)
                .conTipoVehiculo(tipoVehiculo)
                .conValor(8000.0)
                .build();

        List<DtoTarifa> dtoTarifaList = new ArrayList<>();
        dtoTarifaList.add(dtoTarifa);

        Mockito.when(repositorioParqueo.existePorId(parqueo.getId())).thenReturn(true);
        Mockito.when(repositorioFestivo.existe(parqueo.getFechaHoraIngreso().toLocalDate())).thenReturn(true);
        Mockito.when(daoTarifa.listarPorTipoVehiculoYTipoDia(tipoVehiculo, tipoDia)).thenReturn(dtoTarifaList);
        Mockito.when(servicioCrearParqueoDetalle.ejecutar(Mockito.any())).thenReturn(1L);

        ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo = new ServicioRegistrarSalidaParqueo(repositorioParqueo,
                repositorioFestivo,
                daoTarifa,
                servicioCrearParqueoDetalle);

        // Ejecución
        Double valorParqueo = servicioRegistrarSalidaParqueo.ejecutar(parqueo);

        //- assert
        assertEquals(dtoTarifa.getValor() * 2, valorParqueo);
    }


    @Test
    @DisplayName("Deberia registrar la salida del parqueo correctamente con diferente fecha de ingreso y salida y dia regular")
    void deberiaRegistrarLaSalidaDelParqueoCorectamenteConDiferenteFechaDeIngresoYSalidaYDiaRegular() {
        // Arrange
        LocalDateTime fechaHoraIngreso = LocalDateTime.of(2021, 11, 22, 0, 0, 0);
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2021, 11, 23, 23, 59, 59);

        Parqueo parqueo = new ParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaHoraIngreso)
                .conFechaHoraSalida(fechaHoraSalida)
                .build();

        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(parqueo.getTipoVehiculo());
        TipoDia tipoDia = TipoDia.REGULAR;

        DtoTarifa dtoTarifa = new DtoTarifaTestDataBuilder()
                .conId(2)
                .conTipoDia(tipoDia)
                .conTipoVehiculo(tipoVehiculo)
                .conValor(4000.0)
                .build();

        List<DtoTarifa> dtoTarifaList = new ArrayList<>();
        dtoTarifaList.add(dtoTarifa);

        Mockito.when(repositorioParqueo.existePorId(parqueo.getId())).thenReturn(true);
        Mockito.when(repositorioFestivo.existe(parqueo.getFechaHoraIngreso().toLocalDate())).thenReturn(false);
        Mockito.when(daoTarifa.listarPorTipoVehiculoYTipoDia(tipoVehiculo, tipoDia)).thenReturn(dtoTarifaList);
        Mockito.when(servicioCrearParqueoDetalle.ejecutar(Mockito.any())).thenReturn(1L);

        ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo = new ServicioRegistrarSalidaParqueo(repositorioParqueo,
                repositorioFestivo,
                daoTarifa,
                servicioCrearParqueoDetalle);

        // act
        Double valorParqueo = servicioRegistrarSalidaParqueo.ejecutar(parqueo);

        // assert
        assertEquals(dtoTarifa.getValor() * 48, valorParqueo);
    }

    @Test
    @DisplayName("Deberia fallar por no haber ingresado la fecha y hora de salida")
    void deberiaFallarPorNoHaberIngresadoLaFechaYHoraDeSalida() {
        // Arrange
        LocalDateTime fechaHoraSalida = null;

        Parqueo parqueo = new ParqueoTestDataBuilder()
                .conFechaHoraSalida(fechaHoraSalida)
                .build();

        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(parqueo.getTipoVehiculo());
        TipoDia tipoDia = TipoDia.SABADO;

        DtoTarifa dtoTarifa = new DtoTarifaTestDataBuilder().build();
        List<DtoTarifa> dtoTarifaList = new ArrayList<>();
        dtoTarifaList.add(dtoTarifa);

        Mockito.when(repositorioParqueo.existePorId(parqueo.getId())).thenReturn(true);
        Mockito.when(repositorioFestivo.existe(parqueo.getFechaHoraIngreso().toLocalDate())).thenReturn(false);
        Mockito.when(daoTarifa.listarPorTipoVehiculoYTipoDia(tipoVehiculo, tipoDia)).thenReturn(dtoTarifaList);
        Mockito.when(servicioCrearParqueoDetalle.ejecutar(Mockito.any())).thenReturn(1L);

        ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo = new ServicioRegistrarSalidaParqueo(repositorioParqueo,
                repositorioFestivo,
                daoTarifa,
                servicioCrearParqueoDetalle);

        // act - assert
        BasePrueba.assertThrows(() -> servicioRegistrarSalidaParqueo.ejecutar(parqueo),
                ExcepcionValorObligatorio.class,
                DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_SALIDA);
    }
}