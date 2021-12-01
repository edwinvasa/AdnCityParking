package com.ceiba.festivo.controlador;

import com.ceiba.festivo.consulta.ManejadorListarFestivos;
import com.ceiba.festivo.modelo.dto.DtoFestivo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festivos")
@Api(tags = {"Controlador consulta festividades"})
public class ConsultaControladorFestivo {

    private final ManejadorListarFestivos manejadorListarFestivos;

    public ConsultaControladorFestivo(ManejadorListarFestivos manejadorListarFestivos) {
        this.manejadorListarFestivos = manejadorListarFestivos;
    }

    @GetMapping
    @ApiOperation("Listar las festividades")
    public List<DtoFestivo> listar() {
        return this.manejadorListarFestivos.ejecutar();
    }
}
