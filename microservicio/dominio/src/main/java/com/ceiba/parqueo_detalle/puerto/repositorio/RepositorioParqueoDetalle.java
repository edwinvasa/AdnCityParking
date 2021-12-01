package com.ceiba.parqueo_detalle.puerto.repositorio;

import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;

public interface RepositorioParqueoDetalle {

    /**
     * Permite crear un detalle del parqueo
     *
     * @param parqueoDetalle
     * @return el id generado
     */
    Long crear(ParqueoDetalle parqueoDetalle);
}
