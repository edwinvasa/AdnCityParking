package com.ceiba.parqueo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.comando.fabrica.FabricaParqueo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import com.ceiba.parqueo.servicio.ServicioRegistrarSalidaParqueo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorRegistrarSalidaParqueo {

    private final FabricaParqueo fabricaParqueo;
    private final ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo;

    public ManejadorRegistrarSalidaParqueo(FabricaParqueo fabricaParqueo, ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo) {
        this.fabricaParqueo = fabricaParqueo;
        this.servicioRegistrarSalidaParqueo = servicioRegistrarSalidaParqueo;
    }

    @Transactional
    public ComandoRespuesta<Double> ejecutar(ComandoParqueo comandoParqueo) {
        Parqueo parqueo = this.fabricaParqueo.crear(comandoParqueo);
        return new ComandoRespuesta<>(this.servicioRegistrarSalidaParqueo.ejecutar(parqueo));
    }

}
