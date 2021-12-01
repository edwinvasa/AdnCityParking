package com.ceiba.parqueo_detalle.consulta;

import com.ceiba.parqueo_detalle.modelo.dto.DtoParqueoDetalle;
import com.ceiba.parqueo_detalle.puerto.dao.DaoParqueoDetalle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarParqueoDetalles {

    private final DaoParqueoDetalle daoParqueoDetalle;

    public ManejadorListarParqueoDetalles(DaoParqueoDetalle daoParqueoDetalle) {
        this.daoParqueoDetalle = daoParqueoDetalle;
    }

    public List<DtoParqueoDetalle> ejecutar(Long parqueoId) {
        return this.daoParqueoDetalle.listarPorId(parqueoId);
    }

}
