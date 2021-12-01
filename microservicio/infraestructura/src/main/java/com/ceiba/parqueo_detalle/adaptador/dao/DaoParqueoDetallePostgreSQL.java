package com.ceiba.parqueo_detalle.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueo_detalle.modelo.dto.DtoParqueoDetalle;
import com.ceiba.parqueo_detalle.puerto.dao.DaoParqueoDetalle;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoParqueoDetallePostgreSQL implements DaoParqueoDetalle {

    @SqlStatement(namespace = "parqueo_detalle", value = "listarPorParqueoId")
    private static String sqlListarPorParqueoId;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoParqueoDetallePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParqueoDetalle> listarPorId(Long parqueoId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("parqueoId", parqueoId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorParqueoId, paramSource, new MapeoParqueoDetalle());
    }
}
