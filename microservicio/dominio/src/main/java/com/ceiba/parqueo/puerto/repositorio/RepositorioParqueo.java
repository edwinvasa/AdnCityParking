package com.ceiba.parqueo.puerto.repositorio;

import com.ceiba.parqueo.modelo.entidad.Parqueo;

import java.time.LocalDateTime;

public interface RepositorioParqueo {

    /**
     * Permite crear un parqueo
     *
     * @param parqueo
     * @return el id generado
     */
    Long crear(Parqueo parqueo);

    /**
     * Permite validar si ya existe un parqueo con la placa y fecha de ingreso
     *
     * @param placa, fechaHoraIngreso
     * @return si existe o no
     */
    boolean existe(String placa, LocalDateTime fechaHoraIngreso);

    /**
     * Permite actualizar la informacion del parqueo
     *
     * @param parqueo
     */
    void actualizar(Parqueo parqueo);

    /**
     * Permite actualizar la informacion de la salida del parqueo
     *
     * @param parqueo
     */
    void actualizarSalida(Parqueo parqueo);

    /**
     * Permite validar si ya existe un parqueo por medio del id
     *
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
