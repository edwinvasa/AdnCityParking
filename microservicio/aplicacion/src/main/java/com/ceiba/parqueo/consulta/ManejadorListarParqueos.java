package com.ceiba.parqueo.consulta;

import com.ceiba.parqueo.modelo.dto.DtoParqueo;
import com.ceiba.parqueo.puerto.dao.DaoParqueo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarParqueos {

    private final DaoParqueo daoParqueo;

    public ManejadorListarParqueos(DaoParqueo daoParqueo) {
        this.daoParqueo = daoParqueo;
    }

    public List<DtoParqueo> ejecutar() {
        return this.daoParqueo.listar();
    }
}
