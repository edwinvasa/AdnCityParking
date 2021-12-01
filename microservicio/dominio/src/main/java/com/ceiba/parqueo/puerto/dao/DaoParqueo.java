package com.ceiba.parqueo.puerto.dao;

import com.ceiba.parqueo.modelo.dto.DtoParqueo;

import java.util.List;

public interface DaoParqueo {

    /**
     * Permite listar los parqueos
     *
     * @return los parqueos
     */
    List<DtoParqueo> listar();
}
