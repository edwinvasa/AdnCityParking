package com.ceiba.parqueo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.comando.fabrica.FabricaParqueo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.servicio.ServicioCrearParqueo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearParqueo {

    private final FabricaParqueo fabricaParqueo;
    private final ServicioCrearParqueo servicioCrearParqueo;

    public ManejadorCrearParqueo(FabricaParqueo fabricaParqueo, ServicioCrearParqueo servicioCrearParqueo) {
        this.fabricaParqueo = fabricaParqueo;
        this.servicioCrearParqueo = servicioCrearParqueo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoParqueo comandoParqueo) {
        Parqueo parqueo = this.fabricaParqueo.crear(comandoParqueo);
        return new ComandoRespuesta<>(this.servicioCrearParqueo.ejecutar(parqueo));
    }
}
