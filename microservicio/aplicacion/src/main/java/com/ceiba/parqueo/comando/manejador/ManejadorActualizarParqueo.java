package com.ceiba.parqueo.comando.manejador;

import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.comando.fabrica.FabricaParqueo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.servicio.ServicioActualizarParqueo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarParqueo {

    private final FabricaParqueo fabricaParqueo;
    private final ServicioActualizarParqueo servicioActualizarParqueo;

    public ManejadorActualizarParqueo(FabricaParqueo fabricaParqueo, ServicioActualizarParqueo servicioActualizarParqueo) {
        this.fabricaParqueo = fabricaParqueo;
        this.servicioActualizarParqueo = servicioActualizarParqueo;
    }

    @Transactional
    public void ejecutar(ComandoParqueo comandoParqueo) {
        Parqueo parqueo = this.fabricaParqueo.crear(comandoParqueo);
        this.servicioActualizarParqueo.ejecutar(parqueo);

    }
}
