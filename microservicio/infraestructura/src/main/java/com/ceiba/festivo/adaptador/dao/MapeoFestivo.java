package com.ceiba.festivo.adaptador.dao;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoFestivo implements RowMapper<DtoFestivo>, MapperResult {

    @Override
    public DtoFestivo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        String descripcion = resultSet.getString("descripcion");

        return new DtoFestivo(fecha, descripcion);
    }

}
