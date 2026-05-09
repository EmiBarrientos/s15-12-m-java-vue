package com.nc.Propiedades360.app.inmueble.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InmuebleController.class)
@AutoConfigureMockMvc(addFilters = false)
public class InmuebleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InmuebleService inmuebleService;

    private Inmueble inmueble;

    @BeforeEach
    void setUp() {
        inmueble = new Inmueble();
        inmueble.setId(1L);
        inmueble.setTitulo("Casa en Palermo");
        inmueble.setUbicacion("Palermo, CABA");
        inmueble.setPrecio(150000.0);
        inmueble.setEstado(EstadoInmueble.DISPONIBLE);
    }

    // --- obtenerTodos ---

    @Test
    void obtenerTodos_retorna200() throws Exception {
        when(inmuebleService.findAll()).thenReturn(List.of(inmueble));

        mockMvc.perform(get("/inmuebles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Casa en Palermo"));
    }

    // --- obtener ---

    @Test
    void obtener_idExiste_retorna200() throws Exception {
        when(inmuebleService.findById(1L)).thenReturn(inmueble);

        mockMvc.perform(get("/inmuebles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Casa en Palermo"));
    }

    @Test
    void obtener_idNoExiste_retorna404() throws Exception {
        when(inmuebleService.findById(99L))
                .thenThrow(new ResourceNotFoundException("Inmueble no encontrado"));

        mockMvc.perform(get("/inmuebles/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Inmueble no encontrado"));
    }

    // --- actualizarEstado ---

    @Test
    void actualizarEstado_inmuebleExiste_retorna200() throws Exception {
        inmueble.setEstado(EstadoInmueble.RESERVADO);
        when(inmuebleService.actualizarEstado(1L, EstadoInmueble.RESERVADO)).thenReturn(inmueble);

        mockMvc.perform(put("/inmuebles/1/estado")
                        .param("estado", "RESERVADO"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("RESERVADO"));
    }

    @Test
    void actualizarEstado_inmuebleNoExiste_retorna404() throws Exception {
        when(inmuebleService.actualizarEstado(99L, EstadoInmueble.RESERVADO))
                .thenThrow(new ResourceNotFoundException("Inmueble no encontrado"));

        mockMvc.perform(put("/inmuebles/99/estado")
                        .param("estado", "RESERVADO"))
                .andExpect(status().isNotFound());
    }

    // --- eliminar ---

    @Test
    void eliminar_inmuebleExiste_retorna204() throws Exception {
        mockMvc.perform(delete("/inmuebles/1"))
                .andExpect(status().isNoContent());

        verify(inmuebleService, times(1)).deleteById(1L);
    }

    @Test
    void eliminar_inmuebleNoExiste_retorna404() throws Exception {
        doThrow(new ResourceNotFoundException("Inmueble no encontrado"))
                .when(inmuebleService).deleteById(99L);

        mockMvc.perform(delete("/inmuebles/99"))
                .andExpect(status().isNotFound());
    }
}