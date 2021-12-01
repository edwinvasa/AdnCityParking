package com.ceiba.tarifa.controlador;

import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.comando.manejador.ManejadorActualizarTarifa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarifas")
@Api(tags = {"Controlador comando tarifas"})
public class ComandoControladorTarifa {

    private final ManejadorActualizarTarifa manejadorActualizarTarifa;

    @Autowired
    public ComandoControladorTarifa(ManejadorActualizarTarifa manejadorActualizarTarifa) {
        this.manejadorActualizarTarifa = manejadorActualizarTarifa;
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Tarifa; Tipos de Vehiculos: MOTOCICLETA, AUTOMOVIL; Tipos de Dia: FESTIVO, DOMINGO, SABADO, REGULAR")
    public void actualizar(@RequestBody ComandoTarifa comandoTarifa, @PathVariable Integer id) {
        comandoTarifa.setId(id);
        this.manejadorActualizarTarifa.ejecutar(comandoTarifa);
    }
}
