package com.ceiba.parqueo.controlador;

import com.ceiba.parqueo.consulta.ManejadorListarParqueos;
import com.ceiba.parqueo.modelo.dto.DtoParqueo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parqueos")
@Api(tags = {"Controlador consulta parqueo"})
public class ConsultaControladorParqueo {

    private ManejadorListarParqueos manejadorListarParqueos;

    public ConsultaControladorParqueo(ManejadorListarParqueos manejadorListarParqueos) {
        this.manejadorListarParqueos = manejadorListarParqueos;
    }

    @GetMapping
    @ApiOperation("Listar Parqueos")
    public List<DtoParqueo> list() {
        return manejadorListarParqueos.ejecutar();
    }
}
