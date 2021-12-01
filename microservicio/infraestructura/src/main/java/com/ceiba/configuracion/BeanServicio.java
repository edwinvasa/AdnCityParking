package com.ceiba.configuracion;

import com.ceiba.festivo.puerto.repositorio.RepositorioFestivo;
import com.ceiba.parqueo.puerto.repositorio.RepositorioParqueo;
import com.ceiba.parqueo.servicio.ServicioActualizarParqueo;
import com.ceiba.parqueo.servicio.ServicioCrearParqueo;
import com.ceiba.parqueo.servicio.ServicioRegistrarSalidaParqueo;
import com.ceiba.parqueo_detalle.puerto.repositorio.RepositorioParqueoDetalle;
import com.ceiba.parqueo_detalle.servicio.ServicioCrearParqueoDetalle;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.ServicioActualizarTarifa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioActualizarTarifa servicioActualizarTarifa(RepositorioTarifa repositorioTarifa) {
        return new ServicioActualizarTarifa(repositorioTarifa);
    }

    @Bean
    public ServicioCrearParqueo servicioCrearParqueo(RepositorioParqueo repositorioParqueo) {
        return new ServicioCrearParqueo(repositorioParqueo);
    }

    @Bean
    public ServicioActualizarParqueo servicioActualizarParqueo(RepositorioParqueo repositorioParqueo) {
        return new ServicioActualizarParqueo(repositorioParqueo);
    }

    @Bean
    public ServicioRegistrarSalidaParqueo servicioRegistrarSalidaParqueo(RepositorioParqueo repositorioParqueo, RepositorioFestivo repositorioFestivo, DaoTarifa daoTarifa, ServicioCrearParqueoDetalle servicioCrearParqueoDetalle) {
        return new ServicioRegistrarSalidaParqueo(repositorioParqueo, repositorioFestivo, daoTarifa, servicioCrearParqueoDetalle);
    }

    @Bean
    public ServicioCrearParqueoDetalle servicioCrearParqueoDetalle(RepositorioParqueoDetalle repositorioParqueoDetalle) {
        return new ServicioCrearParqueoDetalle(repositorioParqueoDetalle);
    }
}
