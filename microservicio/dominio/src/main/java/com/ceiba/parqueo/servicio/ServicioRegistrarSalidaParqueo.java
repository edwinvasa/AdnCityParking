package com.ceiba.parqueo.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.festivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;
import com.ceiba.parqueo_detalle.servicio.ServicioCrearParqueoDetalle;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ServicioRegistrarSalidaParqueo {

    private static final String EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA = "El parqueo no existe en el sistema";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_SALIDA = "Debe especificar la fecha y hora de salida";
    private static final Integer VEINTITRES_HORAS = 23;
    private static final Integer CERO_HORAS = 0;
    private static final Integer CERO_MINUTOS = 0;
    private static final Integer CINCUENTA_Y_NUEVE_MINUTOS = 59;

    private final RepositorioParqueo repositorioParqueo;
    private final RepositorioFestivo repositorioFestivo;
    private final DaoTarifa daoTarifa;
    private final ServicioCrearParqueoDetalle servicioCrearParqueoDetalle;

    public ServicioRegistrarSalidaParqueo(RepositorioParqueo repositorioParqueo, RepositorioFestivo repositorioFestivo, DaoTarifa daoTarifa, ServicioCrearParqueoDetalle servicioCrearParqueoDetalle) {
        this.repositorioParqueo = repositorioParqueo;
        this.repositorioFestivo = repositorioFestivo;
        this.daoTarifa = daoTarifa;
        this.servicioCrearParqueoDetalle = servicioCrearParqueoDetalle;
    }

    public Double ejecutar(Parqueo parqueo) {
        validarObligatorio(parqueo.getFechaHoraSalida(), DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_SALIDA);
        validarExistenciaPrevia(parqueo);

        List<ParqueoDetalle> parqueoDetalleList = new ArrayList<>();
        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(parqueo.getTipoVehiculo());

        Double valorParqueo;
        LocalDate fechaIngreso = parqueo.getFechaHoraIngreso().toLocalDate();
        LocalDate fechaSalida = parqueo.getFechaHoraSalida().toLocalDate();

        if (fechaIngreso.equals(fechaSalida)) {

            Integer cantidadDeHorasPorDia = calularCantidadDeHoras(parqueo.getFechaHoraIngreso().toLocalTime(), parqueo.getFechaHoraSalida().toLocalTime());
            TipoDia tipoDia = obtenerTipoDeDia(fechaIngreso);
            DtoTarifa tarifa = obtenerTarifa(tipoVehiculo, tipoDia);

            valorParqueo = cantidadDeHorasPorDia * tarifa.getValor();

            ParqueoDetalle parqueoDetalle = new ParqueoDetalle(parqueo.getId(), parqueo.getFechaHoraIngreso(), parqueo.getFechaHoraSalida(), valorParqueo, tarifa.getId());
            parqueoDetalleList.add(parqueoDetalle);

        } else {
            LocalTime horaInicio;
            LocalTime horaFin = LocalTime.of(VEINTITRES_HORAS, CINCUENTA_Y_NUEVE_MINUTOS);
            valorParqueo = 0.0;

            for (LocalDate fecha = fechaIngreso; fecha.isBefore(fechaSalida.plusDays(1)); fecha = fecha.plusDays(1)) {
                horaInicio = LocalTime.of(CERO_HORAS, CERO_MINUTOS);
                TipoDia tipoDia = obtenerTipoDeDia(fecha);
                DtoTarifa tarifa = obtenerTarifa(tipoVehiculo, tipoDia);

                Integer cantidadDeHorasPorDia = 0;
                double valorDia;

                if (fecha.equals(fechaIngreso)) {
                    horaInicio = parqueo.getFechaHoraIngreso().toLocalTime();
                }

                if (fecha.equals(fechaSalida)) {
                    horaFin = parqueo.getFechaHoraSalida().toLocalTime();
                }

                cantidadDeHorasPorDia = calularCantidadDeHoras(horaInicio, horaFin);
                valorDia = cantidadDeHorasPorDia * tarifa.getValor();
                valorParqueo += valorDia;

                LocalDateTime fechaHoraInicio = LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), horaInicio.getHour(), horaInicio.getMinute());
                LocalDateTime fechaHoraFin = LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), horaFin.getHour(), horaFin.getMinute());

                parqueoDetalleList.add(new ParqueoDetalle(parqueo.getId(), fechaHoraInicio, fechaHoraFin, valorDia, tarifa.getId()));
            }
        }
        parqueo.setValor(valorParqueo);

        this.repositorioParqueo.actualizarSalida(parqueo);
        parqueoDetalleList.forEach(this.servicioCrearParqueoDetalle::ejecutar);
        return valorParqueo;
    }

    private DtoTarifa obtenerTarifa(TipoVehiculo tipoDeVehiculo, TipoDia tipoDia) {
        return daoTarifa.listarPorTipoVehiculoYTipoDia(tipoDeVehiculo, tipoDia).get(0);
    }

    private TipoDia obtenerTipoDeDia(LocalDate fecha) {
        if (repositorioFestivo.existe(fecha)) {
            return TipoDia.FESTIVO;
        }

        if (fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return TipoDia.SABADO;
        }

        if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return TipoDia.DOMINGO;
        }

        return TipoDia.REGULAR;
    }

    private Integer calularCantidadDeHoras(LocalTime horaInicio, LocalTime horaFin) {
        Integer cantidadDeHoras = horaFin.getHour() - horaInicio.getHour();
        int diferenciaDeMinutos = horaFin.getMinute() - horaInicio.getMinute();
        if (diferenciaDeMinutos > 0) {
            cantidadDeHoras++;
        }
        return cantidadDeHoras;
    }

    private void validarExistenciaPrevia(Parqueo parqueo) {
        boolean existe = this.repositorioParqueo.existePorId(parqueo.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
