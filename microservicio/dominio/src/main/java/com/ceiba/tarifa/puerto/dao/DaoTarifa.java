package com.ceiba.tarifa.puerto.dao;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;

import java.util.List;

public interface DaoTarifa {

    /**
     * Permite listar tarifas
     *
     * @return las tarifas
     */
    List<DtoTarifa> listar();

    /**
     * Permite listar las tarifas por el tipo de vehiculo y el tipo de dia
     *
     * @return los detalles del parqueo
     */
    List<DtoTarifa> listarPorTipoVehiculoYTipoDia(TipoVehiculo tipoVehiculo, TipoDia tipoDia);
}
