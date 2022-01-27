package com.desafio.assembleia.controller;

import com.desafio.assembleia.business.SessaoBusiness;
import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoRequestDto;
import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoResponseDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SessaoController.class)
class SessaoControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String URL = "/sessao";

    @MockBean
    private SessaoBusiness business;

    @Autowired
    private MockMvc mvc;

    @Test
    void quandoCriarSessao_retornaStatusCodeCreated() throws Exception {

        when(business.criar(any(SessaoRequestDTO.class)))
                .thenReturn(criarSessaoResponseDto());

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarSessaoRequestDto())))
                .andExpect(status().isCreated());
    }

    @Test
    void quansoBuscarSessaoPorId_retornaStatusCodeOk() throws Exception {

        when(business.buscarPorId(anyLong()))
                .thenReturn(criarSessaoResponseDto());

        mvc.perform(MockMvcRequestBuilders.get(URL.concat("/{id}"), 1L)
                .content(getJsonPayload(1L, "aberta", 2L))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    String getJsonPayload(Long id, String status, Long idPauta) throws JsonProcessingException {

        SessaoResponseDTO sessaoResponseDTO = SessaoResponseDTO.builder()
                .id(id).status(status).idPauta(idPauta).build();

        return mapper.writeValueAsString(sessaoResponseDTO);
    }
}