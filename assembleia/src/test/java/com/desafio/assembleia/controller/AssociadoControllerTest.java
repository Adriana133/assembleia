package com.desafio.assembleia.controller;

import com.desafio.assembleia.converter.AssociadoConverter;
import com.desafio.assembleia.dto.AssociadoRequestDTO;
import com.desafio.assembleia.dto.AssociadoResponseDTO;
import com.desafio.assembleia.entity.AssociadoEntity;
import com.desafio.assembleia.service.AssociadoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.desafio.assembleia.utils.AssociadoUtils.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AssociadoController.class)
class AssociadoControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String URL = "/associado";

    @MockBean
    private AssociadoService service;

    @MockBean
    private AssociadoConverter converter;

    @Autowired
    private MockMvc mvc;

    @Test
    void quandoSalvar_retornaStatusCodeCreated() throws Exception {

        AssociadoEntity entity = criarAssociadoEntity();

        when(converter.toResponseDto(any(AssociadoEntity.class)))
                .thenReturn(criarAssociadoResponseDto());
        when(service.salvar(any(AssociadoEntity.class)))
                .thenReturn(entity);
        when(converter.requestDtoToEntity(any(AssociadoRequestDTO.class)))
                .thenReturn(entity);

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarAssociadoRequestDto())))
                .andExpect(status().isCreated());
    }

    @Test
    void quandoListar_retornaStatusCodeOk() throws Exception {

        List<AssociadoEntity> listEntity = criarListAssociadoEntity();

        when(converter.toListDto(listEntity))
                .thenReturn(criarListAssociadoResponseDto());
        when(service.listar())
                .thenReturn(listEntity);

        mvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void quandoBuscarPorId_retornaStatusCodeOk() throws Exception {

        when(converter.toResponseDto(any(AssociadoEntity.class)))
                .thenReturn(criarAssociadoResponseDto());
        when(service.buscarPorId(anyLong()))
                .thenReturn(criarAssociadoEntity());

        mvc.perform(MockMvcRequestBuilders.get(URL.concat("/{id}"), 1L)
                .content(getJsonPayload(1L, "99623161034", "Ana"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void quandoAtualizar_retornaStatusCodeOk() throws Exception {

        AssociadoEntity entity = criarAssociadoEntity();
        entity.setCpf("Associado atualizado");

        when(converter.toResponseDto(any(AssociadoEntity.class)))
                .thenReturn(criarAssociadoResponseDto());
        when(service.atualizar(any(AssociadoEntity.class), anyLong()))
                .thenReturn(entity);
        when(converter.requestDtoToEntity(any(AssociadoRequestDTO.class)))
                .thenReturn(entity);

        MockHttpServletRequestBuilder requestBuilder = put("/associado/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarAssociadoRequestDto()));

        mvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    void quandoExcluirPorId_retornaStatusCodeOk() throws Exception {

        mvc.perform(MockMvcRequestBuilders.delete(URL.concat("/{id}"), 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    void quandoExcluirTodos_retornaStatusCodeOk() throws Exception {

        mvc.perform(MockMvcRequestBuilders.delete(URL))
                .andExpect(status().isNoContent());
    }

    String getJsonPayload(Long id, String cpf, String nome) throws JsonProcessingException {

        AssociadoResponseDTO associadoResponseDTO = AssociadoResponseDTO.builder()
                .id(id).cpf(cpf).nome(nome).build();

        return mapper.writeValueAsString(associadoResponseDTO);
    }
}