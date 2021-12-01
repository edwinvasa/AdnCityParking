package com.ceiba.parqueo_detalle.servicio;

import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;
import com.ceiba.parqueo_detalle.puerto.repositorio.RepositorioParqueoDetalle;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

public class ServicioCrearParqueoDetalle {

    private static final String LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_FIN = "La fecha y hora de inicio debe ser menor o igual a la fecha y hora de fin";
    private final RepositorioParqueoDetalle repositorioParqueoDetalle;

    public ServicioCrearParqueoDetalle(RepositorioParqueoDetalle repositorioParqueoDetalle) {
        this.repositorioParqueoDetalle = repositorioParqueoDetalle;
    }

    public Long ejecutar(ParqueoDetalle parqueoDetalle) {
        validarMenor(parqueoDetalle.getFechaHoraInicio(), parqueoDetalle.getFechaHoraFin(), LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_FIN);

        return this.repositorioParqueoDetalle.crear(parqueoDetalle);
    }

}
