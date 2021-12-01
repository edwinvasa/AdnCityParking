package com.ceiba.tarifa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTarifa implements RowMapper<DtoTarifa>, MapperResult {


    @Override
    public DtoTarifa mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(resultSet.getString("tipo_vehiculo"));
        TipoDia tipoDia = TipoDia.valueOf(resultSet.getString("tipo_dia"));
        Double valor = resultSet.getDouble("valor");

        return new DtoTarifa(id, nombre, tipoVehiculo, tipoDia, valor);
    }
}
