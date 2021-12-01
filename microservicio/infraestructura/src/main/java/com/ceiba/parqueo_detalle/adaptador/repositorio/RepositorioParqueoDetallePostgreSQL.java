package com.ceiba.parqueo_detalle.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueo_detalle.modelo.entidad.ParqueoDetalle;
import com.ceiba.parqueo_detalle.puerto.repositorio.RepositorioParqueoDetalle;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioParqueoDetallePostgreSQL implements RepositorioParqueoDetalle {

    @SqlStatement(namespace = "parqueo_detalle", value = "crear")
    private static String sqlCrearParqueoDetalle;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioParqueoDetallePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(ParqueoDetalle parqueoDetalle) {
        return this.customNamedParameterJdbcTemplate.crear(parqueoDetalle, sqlCrearParqueoDetalle);
    }
}
