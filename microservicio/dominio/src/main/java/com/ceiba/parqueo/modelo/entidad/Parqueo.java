package com.ceiba.parqueo.modelo.entidad;

import com.ceiba.parqueo.modelo.enums.TipoVehiculo;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class Parqueo {

    private static final String DEBE_INGRESAR_LA_PLACA = "Debe ingresar la placa";
    private static final String EL_TIPO_DE_VEHICULO_NO_ES_CORRECTO = "El tipo de vehiculo no es correcto";
    private static final String DEBE_INGRESAR_EL_TIPO_DE_VEHICULO = "Debe ingresar el tipo de vehiculo";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INGRESO = "Debe especificar la fecha y hora de ingreso";
    private static final String LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_ACTUAL = "La fecha y hora de ingreso debe ser menor o igual a la fecha y hora actual";
    private static final String LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_SALIDA = "La fecha y hora de ingreso debe ser menor o igual a la fecha y hora de salida";

    private Long id;
    private String placa;
    private String tipoVehiculo;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private Double valor;
    private String observacion;

    public Parqueo(Long id, String placa, String tipoVehiculo, LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida, Double valor, String observacion) {
        validarObligatorio(placa, DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(tipoVehiculo, DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
        validarValido(tipoVehiculo, TipoVehiculo.class, EL_TIPO_DE_VEHICULO_NO_ES_CORRECTO);
        validarObligatorio(fechaHoraIngreso, DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INGRESO);
        validarMenor(fechaHoraIngreso, LocalDateTime.now(), LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_ACTUAL);
        if (fechaHoraSalida != null) {
            validarMenor(fechaHoraIngreso, fechaHoraSalida, LA_FECHA_Y_HORA_DE_INGRESO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_DE_SALIDA);
        }

        this.id = id;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.fechaHoraSalida = fechaHoraSalida;
        this.valor = valor;
        this.observacion = observacion;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public Double getValor() {
        return valor;
    }

    public String getObservacion() {
        return observacion;
    }
}
