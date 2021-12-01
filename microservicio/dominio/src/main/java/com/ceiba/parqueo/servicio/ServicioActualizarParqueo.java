package com.ceiba.parqueo.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;

public class ServicioActualizarParqueo {

    private static final String EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA = "El parqueo no existe en el sistema";

    private final RepositorioParqueo repositorioParqueo;

    public ServicioActualizarParqueo(RepositorioParqueo repositorioParqueo) {
        this.repositorioParqueo = repositorioParqueo;
    }

    public void ejecutar(Parqueo parqueo) {
        validarExistenciaPrevia(parqueo);
        this.repositorioParqueo.actualizar(parqueo);
    }

    private void validarExistenciaPrevia(Parqueo parqueo) {
        boolean existe = this.repositorioParqueo.existePorId(parqueo.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PARQUEO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
