package com.ceiba.parqueo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueo.modelo.dto.DtoParqueo;
import com.ceiba.parqueo.puerto.dao.DaoParqueo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoParqueoPostgreSQL implements DaoParqueo {

    @SqlStatement(namespace = "parqueo", value = "listar")
    private static String sqlListarParqueo;
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoParqueoPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParqueo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarParqueo, new MapeoParqueo());
    }
}
