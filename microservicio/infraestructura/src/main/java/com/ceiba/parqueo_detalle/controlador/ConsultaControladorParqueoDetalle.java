package com.ceiba.parqueo_detalle.controlador;

import com.ceiba.parqueo_detalle.consulta.ManejadorListarParqueoDetalles;
import com.ceiba.parqueo_detalle.modelo.dto.DtoParqueoDetalle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parqueo_detalles")
@Api("Controlador consulta parqueo detalle")
public class ConsultaControladorParqueoDetalle {

    private final ManejadorListarParqueoDetalles manejadorListarParqueoDetalles;

    public ConsultaControladorParqueoDetalle(ManejadorListarParqueoDetalles manejadorListarParqueoDetalles) {
        this.manejadorListarParqueoDetalles = manejadorListarParqueoDetalles;
    }

    @GetMapping(value = "/{parqueoId}")
    @ApiOperation("Listar detalles de un parqueo por medio del identificador")
    public List<DtoParqueoDetalle> listarPorId(@PathVariable Long parqueoId) {
        return manejadorListarParqueoDetalles.ejecutar(parqueoId);
    }
}
