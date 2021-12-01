package com.ceiba.festivo.consulta;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.festivo.puerto.dao.DaoFestivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFestivos {

    private final DaoFestivo daoFestivo;

    public ManejadorListarFestivos(DaoFestivo daoFestivo) {
        this.daoFestivo = daoFestivo;
    }

    public List<DtoFestivo> ejecutar() {
        return this.daoFestivo.listar();
    }
}
