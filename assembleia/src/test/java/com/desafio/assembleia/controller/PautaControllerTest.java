package com.desafio.assembleia.controller;

import com.desafio.assembleia.converter.PautaConverter;
import com.desafio.assembleia.dto.PautaRequestDTO;
import com.desafio.assembleia.dto.PautaResponseDTO;
import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.service.PautaService;
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

import static com.desafio.assembleia.utils.PautaUtils.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PautaController.class)
class PautaControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String URL = "/pauta";

    @MockBean
    private PautaService service;

    @MockBean
    private PautaConverter converter;

    @Autowired
    private MockMvc mvc;

    @Test
    void quandoSalvar_retornaStatusCodeCreated() throws Exception {

        PautaEntity entity = criarPautaEntity();

        when(converter.toResponseDTO(any(PautaEntity.class)))
                .thenReturn(criarPautaResponseDto());
        when(service.salvar(any(PautaEntity.class)))
                .thenReturn(entity);
        when(converter.requestDtoToEntity(any(PautaRequestDTO.class)))
                .thenReturn(entity);

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarPautaRequestDto())))
                .andExpect(status().isCreated());
    }

    @Test
    void quandoListar_retornaStatusCodeOk() throws Exception {

        List<PautaEntity> entityList = criarListaEntity();

        when(converter.toListDto(entityList)).thenReturn(criarListaResponseDto());
        when(service.listar()).thenReturn(entityList);

        mvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void quandoBuscarPorId_retornaStatusCodeOk() throws Exception {

        when(converter.toResponseDTO(any(PautaEntity.class)))
                .thenReturn(criarPautaResponseDto());
        when(service.buscarPorId(anyLong()))
                .thenReturn(criarPautaEntity());

        mvc.perform(MockMvcRequestBuilders.get(URL.concat("/{id}"), 1L)
                .content(getJsonPayload(1L, "Pauta em votação"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void quandoAtualizar_retornaStatusCodeOk() throws Exception {

        PautaEntity entity = criarPautaEntity();
        entity.setDescricao("descrição atualizada");

        when(converter.toResponseDTO(any(PautaEntity.class)))
                .thenReturn(criarPautaResponseDto());
        when(service.atualizar(any(PautaEntity.class), anyLong()))
                .thenReturn(entity);
        when(converter.requestDtoToEntity(any(PautaRequestDTO.class)))
                .thenReturn(entity);

        MockHttpServletRequestBuilder requestBuilder = put("/pauta/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarPautaRequestDto()));

        mvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    void quandoExcluirPorId_retornaStatusCodeOk() throws Exception {

        mvc.perform(MockMvcRequestBuilders.delete(URL.concat("/{id}"), 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    void excluirTodos_retornaStatusCodeOk() throws Exception {

        mvc.perform(MockMvcRequestBuilders.delete(URL))
                .andExpect(status().isNoContent());
    }

    String getJsonPayload(Long id, String descricao) throws JsonProcessingException {

        PautaResponseDTO pautaResponseDTO = PautaResponseDTO.builder()
                .id(id).descricao(descricao).build();

        return mapper.writeValueAsString(pautaResponseDTO);
    }
}