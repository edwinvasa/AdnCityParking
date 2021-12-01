package com.ceiba.parqueo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioParqueoPostgreSQL implements RepositorioParqueo {

    @SqlStatement(namespace = "parqueo", value = "existe")
    private static String sqlExisteParqueo;
    @SqlStatement(namespace = "parqueo", value = "existePorId")
    private static String sqlExistePorIdParqueo;
    @SqlStatement(namespace = "parqueo", value = "crear")
    private static String sqlCrearParqueo;
    @SqlStatement(namespace = "parqueo", value = "actualizar")
    private static String sqlActualizarParqueo;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioParqueoPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Parqueo parqueo) {
        return this.customNamedParameterJdbcTemplate.crear(parqueo, sqlCrearParqueo);
    }

    @Override
    public boolean existe(String placa, LocalDateTime fechaHoraIngreso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        paramSource.addValue("fechaHoraIngreso", fechaHoraIngreso);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteParqueo, paramSource, Boolean.class));
    }

    @Override
    public void actualizar(Parqueo parqueo) {
        this.customNamedParameterJdbcTemplate.actualizar(parqueo, sqlActualizarParqueo);
    }

    @Override
    public void actualizarSalida(Parqueo parqueo) {
        this.customNamedParameterJdbcTemplate.actualizar(parqueo, sqlActualizarParqueo);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdParqueo, paramSource, Boolean.class));

    }
}
