package com.ceiba.parqueo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;

public class ServicioCrearParqueo {

    private static final String EL_PARQUEO_YA_EXISTE = "El parqueo ya existe";

    private final RepositorioParqueo repositorioParqueo;

    public ServicioCrearParqueo(RepositorioParqueo repositorioParqueo) {
        this.repositorioParqueo = repositorioParqueo;
    }

    public Long ejecutar(Parqueo parqueo) {
        validarExistenciaPrevia(parqueo);
        return this.repositorioParqueo.crear(parqueo);
    }

    private void validarExistenciaPrevia(Parqueo parqueo) {
        boolean existe = this.repositorioParqueo.existe(parqueo.getPlaca(), parqueo.getFechaHoraIngreso());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PARQUEO_YA_EXISTE);
        }
    }

}
