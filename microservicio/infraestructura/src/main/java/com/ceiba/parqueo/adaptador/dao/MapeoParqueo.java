package com.ceiba.parqueo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parqueo.modelo.dto.DtoParqueo;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoParqueo implements RowMapper<DtoParqueo>, MapperResult {

    @Override
    public DtoParqueo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(resultSet.getString("tipo_vehiculo"));
        LocalDateTime fechaHoraIngreso = extraerLocalDateTime(resultSet, "fecha_hora_ingreso");
        LocalDateTime fechaHoraSalida = extraerLocalDateTime(resultSet, "fecha_hora_salida");
        Double valor = resultSet.getDouble("valor");
        String observacion = resultSet.getString("observacion");

        return new DtoParqueo(id, placa, tipoVehiculo, fechaHoraIngreso, fechaHoraSalida, valor, observacion);
    }
}
