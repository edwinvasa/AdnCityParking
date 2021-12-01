package com.ceiba.tarifa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTarifaPostgreSQL implements DaoTarifa {

    @SqlStatement(namespace = "tarifa", value = "listar")
    private static String sqlListarTarifa;
    @SqlStatement(namespace = "tarifa", value = "listarPorTipoVehiculoYTipoDia")
    private static String sqlLListarPorTipoVehiculoYTipoDia;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoTarifaPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTarifa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTarifa, new MapeoTarifa());
    }

    @Override
    public List<DtoTarifa> listarPorTipoVehiculoYTipoDia(TipoVehiculo tipoVehiculo, TipoDia tipoDia) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoVehiculo", tipoVehiculo.name());
        paramSource.addValue("tipoDia", tipoDia.name());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlLListarPorTipoVehiculoYTipoDia, paramSource, new MapeoTarifa());
    }
}
