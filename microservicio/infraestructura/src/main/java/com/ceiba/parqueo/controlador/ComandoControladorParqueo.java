package com.ceiba.parqueo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.comando.manejador.ManejadorActualizarParqueo;
import com.ceiba.parqueo.comando.manejador.ManejadorCrearParqueo;
import com.ceiba.parqueo.comando.manejador.ManejadorRegistrarSalidaParqueo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parqueos")
@Api(tags = {"Controlador comando parqueo"})
public class ComandoControladorParqueo {

    private final ManejadorCrearParqueo manejadorCrearParqueo;
    private final ManejadorActualizarParqueo manejadorActualizarParqueo;
    private final ManejadorRegistrarSalidaParqueo manejadorRegistrarSalidaParqueo;

    public ComandoControladorParqueo(ManejadorCrearParqueo manejadorCrearParqueo,
                                     ManejadorActualizarParqueo manejadorActualizarParqueo,
                                     ManejadorRegistrarSalidaParqueo manejadorRegistrarSalidaParqueo) {
        this.manejadorCrearParqueo = manejadorCrearParqueo;
        this.manejadorActualizarParqueo = manejadorActualizarParqueo;
        this.manejadorRegistrarSalidaParqueo = manejadorRegistrarSalidaParqueo;
    }

    @PostMapping
    @ApiOperation("Crear parqueo, Tipos de Vehiculos validos: AUTOMOVIL, MOTOCICLETA")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoParqueo comandoParqueo) {
        return manejadorCrearParqueo.ejecutar(comandoParqueo);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Parqueo")
    public void actualizar(@RequestBody ComandoParqueo comandoParqueo, @PathVariable Long id) {
        comandoParqueo.setId(id);
        manejadorActualizarParqueo.ejecutar(comandoParqueo);
    }

    @PutMapping(value = "/salida/{id}")
    @ApiOperation("Actualizar y Registrar Salida Parqueo")
    public ComandoRespuesta<Double> registrarSalidaParqueo(@RequestBody ComandoParqueo comandoParqueo, @PathVariable Long id) {
        comandoParqueo.setId(id);
        return manejadorRegistrarSalidaParqueo.ejecutar(comandoParqueo);
    }
}
