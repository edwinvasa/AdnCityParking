package com.ceiba.parqueo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.parqueo.comando.ComandoParqueo;
import com.ceiba.parqueo.modelo.enums.TipoVehiculo;
import com.ceiba.parqueo.servicio.testdatabuilder.ComandoParqueoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorParqueo.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorParqueoTest {

    private ObjectMapper objectMapper;
    private MockMvc mocMvc;

    @Autowired
    ComandoControladorParqueoTest(ObjectMapper objectMapper, MockMvc mocMvc) {
        this.objectMapper = objectMapper;
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia crear un parqueo")
    void deberiaCrearUnParqueo() throws Exception {
        // arrange
        ComandoParqueo parqueo = new ComandoParqueoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/parqueos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(parqueo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un parqueo")
    void deberiaActualizarUnParqueo() throws Exception {
        // arrange
        Long id = 1L;
        ComandoParqueo parqueo = new ComandoParqueoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/parqueos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(parqueo)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia actualizar y registrar la salida del parqueo")
    void deberiaActualizarYRegistrarLaSalidaDelParqueo() throws Exception {
        // arrange
        Long id = 1L;
        LocalDateTime fechaHoraIngreso = LocalDateTime.of(2021, 11, 29, 0, 0, 0);
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2021, 11, 30, 23, 59, 0);
        ComandoParqueo parqueo = new ComandoParqueoTestDataBuilder()
                .conFechaHoraIngreso(fechaHoraIngreso)
                .conFechaHoraSalida(fechaHoraSalida)
                .conId(id)
                .conPlaca("GIX978B")
                .conTipoVehiculo(String.valueOf(TipoVehiculo.MOTOCICLETA))
                .conValor(0.0)
                .build();

        // act - assert
        mocMvc.perform(put("/parqueos/salida/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(parqueo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 96000.0}"));
    }

}