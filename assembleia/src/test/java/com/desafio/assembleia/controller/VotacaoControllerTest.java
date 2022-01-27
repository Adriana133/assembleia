package com.desafio.assembleia.controller;

import com.desafio.assembleia.business.VotacaoBusiness;
import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoRequestDto;
import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoResponseDto;
import static com.desafio.assembleia.utils.VotacaoUtils.criarVotacaoRequestDto;
import static com.desafio.assembleia.utils.VotacaoUtils.criarVotacaoResponseDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VotacaoController.class)
class VotacaoControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private final String URL = "/votacao";

    @MockBean
    private VotacaoBusiness business;

    @Autowired
    private MockMvc mvc;

    @Test
    void quandoVotar_retornaStatusCodeCreated() throws Exception {

        when(business.votar(any(VotacaoRequestDTO.class)))
                .thenReturn(criarVotacaoResponseDto());

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(criarVotacaoRequestDto())))
                .andExpect(status().isCreated());
    }
}