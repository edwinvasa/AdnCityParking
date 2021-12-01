package com.ceiba.festivo.adaptador.dao;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.festivo.puerto.dao.DaoFestivo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoFestivoPostgreSQL implements DaoFestivo {

    @SqlStatement(namespace = "festivo", value = "listar")
    private static String sqlListarFestivo;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoFestivoPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoFestivo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarFestivo, new MapeoFestivo());
    }
}
