package com.ceiba.festivo.puerto.repositorio;

import java.time.LocalDate;

public interface RepositorioFestivo {
    /**
     * Permite validar si existe un festivo con una fecha
     *
     * @param fecha : fecha a consultar
     * @return si existe o no
     */
    boolean existe(LocalDate fecha);

}
