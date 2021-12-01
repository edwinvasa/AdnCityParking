package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioActualizarTarifa {

    private static final String LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA = "La tarifa no existe en el sistema";

    private final RepositorioTarifa repositorioTarifa;

    public ServicioActualizarTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public void ejecutar(Tarifa tarifa) {
        validarExistenciaPrevia(tarifa);
        this.repositorioTarifa.actualizar(tarifa);
    }

    private void validarExistenciaPrevia(Tarifa tarifa) {
        boolean existe = this.repositorioTarifa.existePorId(tarifa.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
