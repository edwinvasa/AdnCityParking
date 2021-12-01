package com.ceiba.parqueo.comando.fabrica;

import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.modelo.entidad.Parqueo;
import org.springframework.stereotype.Component;

@Component
public class FabricaParqueo {

    public Parqueo crear(ComandoParqueo comandoParqueo) {
        return new Parqueo(
                comandoParqueo.getId(),
                comandoParqueo.getPlaca(),
                comandoParqueo.getTipoVehiculo(),
                comandoParqueo.getFechaHoraIngreso(),
                comandoParqueo.getFechaHoraSalida(),
                comandoParqueo.getValor(),
                comandoParqueo.getObservacion()
        );
    }
}
