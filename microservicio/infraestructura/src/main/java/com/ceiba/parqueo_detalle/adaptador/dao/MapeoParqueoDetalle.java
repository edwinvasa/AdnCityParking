package com.ceiba.parqueo_detalle.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parqueo_detalle.modelo.dto.DtoParqueoDetalle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoParqueoDetalle implements RowMapper<DtoParqueoDetalle>, MapperResult {

    @Override
    public DtoParqueoDetalle mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long parqueoId = resultSet.getLong("parqueo_id");
        LocalDateTime fechaHoraInicio = extraerLocalDateTime(resultSet, "fecha_hora_inicio");
        LocalDateTime fechaHoraFin = extraerLocalDateTime(resultSet, "fecha_hora_fin");
        Double valor = resultSet.getDouble("valor");
        Integer tarifaId = resultSet.getInt("tarifa_id");

        return new DtoParqueoDetalle(id, parqueoId, fechaHoraInicio, fechaHoraFin, valor, tarifaId);
    }
}
