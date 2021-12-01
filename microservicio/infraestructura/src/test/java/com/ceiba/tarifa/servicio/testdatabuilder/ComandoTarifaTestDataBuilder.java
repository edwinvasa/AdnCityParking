package com.ceiba.tarifa.servicio.testdatabuilder;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.tarifa.comando.ComandoTarifa;

public class ComandoTarifaTestDataBuilder {

    private Integer id;
    private String nombre;
    private String tipoVehiculo;
    private String tipoDia;
    private Double valor;

    public ComandoTarifaTestDataBuilder() {
        id = 1;
        nombre = "Estandar Motocicletas";
        tipoVehiculo = String.valueOf(TipoVehiculo.MOTOCICLETA);
        tipoDia = String.valueOf(TipoDia.REGULAR);
        valor = 3000.0;
    }

    public ComandoTarifaTestDataBuilder conId(Integer id) {
        this.id = id;
        return this;
    }

    public ComandoTarifaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoTarifaTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ComandoTarifaTestDataBuilder conTipoDia(String tipoDia) {
        this.tipoDia = tipoDia;
        return this;
    }

    public ComandoTarifaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoTarifa build() {
        return new ComandoTarifa(id, nombre, tipoVehiculo, tipoDia, valor);
    }

}
