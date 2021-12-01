package com.ceiba.tarifa.modelo.entidad;

import com.ceiba.parqueo.modelo.enums.TipoDia;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarValido;

public class Tarifa {

    private static final String EL_VALOR_INGRESADO_DEBE_SER_MAYOR_A_CERO = "El valor ingresado debe ser mayor a cero";
    private static final String EL_TIPO_DE_VEHICULO_NO_EXISTE = "El tipo de vehiculo no existe";
    private static final String EL_TIPO_DE_DIA_NO_EXISTE = "El tipo de dia no existe";

    private static final long VALOR_MINIMO = 0;

    private Integer id;
    private String nombre;
    private TipoVehiculo tipoVehiculo;
    private TipoDia tipoDia;
    private Double valor;

    public Tarifa(Integer id, String nombre, String tipoVehiculo, String tipoDia, Double valor) {
        validarMenor(VALOR_MINIMO, valor.longValue(), EL_VALOR_INGRESADO_DEBE_SER_MAYOR_A_CERO);
        validarValido(tipoVehiculo, TipoVehiculo.class, EL_TIPO_DE_VEHICULO_NO_EXISTE);
        validarValido(tipoDia, TipoDia.class, EL_TIPO_DE_DIA_NO_EXISTE);

        this.id = id;
        this.nombre = nombre;
        this.tipoVehiculo = TipoVehiculo.valueOf(tipoVehiculo);
        this.tipoDia = TipoDia.valueOf(tipoDia);
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public TipoDia getTipoDia() {
        return tipoDia;
    }

    public Double getValor() {
        return valor;
    }
}
