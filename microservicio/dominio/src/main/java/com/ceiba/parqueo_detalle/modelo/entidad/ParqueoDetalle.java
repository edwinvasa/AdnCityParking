package com.ceiba.parqueo_detalle.modelo.entidad;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class ParqueoDetalle {

    private static final String DEBE_INGRESAR_EL_PARQUEO = "Debe ingresar el parqueo";
    private static final String DEBE_INGRESAR_EL_TIPO_DE_TARIFA = "Debe ingresar el tipo de tarifa";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INICIO = "Debe especificar la fecha y hora de Inicio";
    private static final String DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_FIN = "Debe especificar la fecha y hora de Fin";
    private static final String LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN = "La fecha y hora de inicio debe ser menor o igual a la fecha y hora fin";

    private Long id;
    private Long parqueoId;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Double valor;
    private Integer tarifaId;

    public ParqueoDetalle(Long id, Long parqueoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Double valor, Integer tarifaId) {
        this(parqueoId, fechaHoraInicio, fechaHoraFin, valor, tarifaId);
        this.id = id;
    }

    public ParqueoDetalle(Long parqueoId, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Double valor, Integer tarifaId) {
        validarObligatorio(parqueoId, DEBE_INGRESAR_EL_PARQUEO);
        validarObligatorio(tarifaId, DEBE_INGRESAR_EL_TIPO_DE_TARIFA);
        validarObligatorio(fechaHoraInicio, DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_INICIO);
        validarObligatorio(fechaHoraFin, DEBE_INGRESAR_LA_FECHA_Y_HORA_DE_FIN);
        validarMenor(fechaHoraInicio, fechaHoraFin, LA_FECHA_Y_HORA_DE_INICIO_DEBE_SER_MENOR_O_IGUAL_A_LA_FECHA_Y_HORA_FIN);

        this.parqueoId = parqueoId;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.valor = valor;
        this.tarifaId = tarifaId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getParqueoId() {
        return parqueoId;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getTarifaId() {
        return tarifaId;
    }
}
