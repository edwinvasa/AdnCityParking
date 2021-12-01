package com.ceiba.tarifa.consulta;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTarifas {

    private final DaoTarifa daoTarifa;

    public ManejadorListarTarifas(DaoTarifa daoTarifa) {
        this.daoTarifa = daoTarifa;
    }

    public List<DtoTarifa> ejecutar() {
        return this.daoTarifa.listar();
    }
}
