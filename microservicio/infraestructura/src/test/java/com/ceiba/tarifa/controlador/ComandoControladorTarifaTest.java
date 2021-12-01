package com.ceiba.tarifa.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.ComandoTarifaTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorTarifa.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorTarifaTest {

    private ObjectMapper objectMapper;
    private MockMvc mocMvc;

    @Autowired
    ComandoControladorTarifaTest(ObjectMapper objectMapper, MockMvc mocMvc) {
        this.objectMapper = objectMapper;
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia actualizar una tarifa")
    void deberiaActualizarUnaTarifa() throws Exception {
        // arrange
        Integer id = 1;
        ComandoTarifa tarifa = new ComandoTarifaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/tarifas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarifa)))
                .andExpect(status().isOk());
    }

}