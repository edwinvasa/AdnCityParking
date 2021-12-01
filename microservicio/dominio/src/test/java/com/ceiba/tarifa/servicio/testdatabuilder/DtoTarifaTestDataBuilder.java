package com.ceiba.tarifa.servicio.testdatabuilder;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;

public class DtoTarifaTestDataBuilder {

    private final String nombre;
    private Integer id;
    private TipoVehiculo tipoVehiculo;
    private TipoDia tipoDia;
    private Double valor;

    public DtoTarifaTestDataBuilder() {
        id = 8;
        nombre = "Festivo Automovil";
        tipoVehiculo = TipoVehiculo.AUTOMOVIL;
        tipoDia = TipoDia.FESTIVO;
        valor = 8000.0;
    }

    public DtoTarifaTestDataBuilder conId(Integer id) {
        this.id = id;
        return this;
    }

    public DtoTarifaTestDataBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public DtoTarifaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public DtoTarifaTestDataBuilder conTipoDia(TipoDia tipoDia) {
        this.tipoDia = tipoDia;
        return this;
    }

    public DtoTarifa build() {
        return new DtoTarifa(id, nombre, tipoVehiculo, tipoDia, valor);
    }

}
