package com.ceiba.tarifa.servicio.testdatabuilder;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.modelo.entidad.Tarifa;

public class TarifaTestDataBuilder {

    private Integer id;
    private String nombre;
    private String tipoVehiculo;
    private String tipoDia;
    private Double valor;

    public TarifaTestDataBuilder() {
        id = 8;
        nombre = "Domingo Automovil";
        tipoVehiculo = String.valueOf(TipoVehiculo.AUTOMOVIL);
        tipoDia = String.valueOf(TipoDia.DOMINGO);
        valor = 8000.0;
    }

    public TarifaTestDataBuilder conId(Integer id) {
        this.id = id;
        return this;
    }

    public TarifaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TarifaTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public TarifaTestDataBuilder conTipoDia(String tipoDia) {
        this.tipoDia = tipoDia;
        return this;
    }

    public TarifaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Tarifa build() {
        return new Tarifa(id, nombre, tipoVehiculo, tipoDia, valor);
    }
}
