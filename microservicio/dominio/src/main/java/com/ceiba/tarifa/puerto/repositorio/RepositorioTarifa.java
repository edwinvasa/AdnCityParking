package com.ceiba.tarifa.puerto.repositorio;

import com.ceiba.tarifa.modelo.entidad.Tarifa;

public interface RepositorioTarifa {
    /**
     * Permite actualizar una tarifa
     *
     * @param tarifa
     */
    void actualizar(Tarifa tarifa);

    /**
     * Permite validar si existe una tarifa con por medio del id
     *
     * @return si existe o no
     */
    boolean existePorId(Integer id);

}
