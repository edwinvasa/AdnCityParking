package com.ceiba.festivo.puerto.dao;

import com.ceiba.festivo.modelo.dto.DtoFestivo;

import java.util.List;

public interface DaoFestivo {

    /**
     * Permite listar festivos
     *
     * @return los festivos
     */
    List<DtoFestivo> listar();
}
