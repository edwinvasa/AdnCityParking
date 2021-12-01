package com.ceiba.parqueo_detalle.puerto.dao;

import com.ceiba.parqueo_detalle.modelo.dto.DtoParqueoDetalle;

import java.util.List;

public interface DaoParqueoDetalle {

    /**
     * Permite listar el detalle del parqueo
     *
     * @return los detalles del parqueo
     */
    List<DtoParqueoDetalle> listarPorId(Long parqueoId);
}
