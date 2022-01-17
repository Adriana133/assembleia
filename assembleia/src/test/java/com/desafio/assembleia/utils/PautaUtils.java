package com.desafio.assembleia.utils;

import com.desafio.assembleia.dto.PautaRequestDTO;
import com.desafio.assembleia.dto.PautaResponseDTO;
import com.desafio.assembleia.entity.PautaEntity;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

public abstract class PautaUtils {

    public static PautaResponseDTO criarPautaResponseDto() {
        return PautaResponseDTO.builder()
                .id(1L)
                .descricao("Pauta de votação")
                .build();
    }

    public static PautaEntity criarPautaEntity() {
        return PautaEntity.builder()
                .id(1L)
                .descricao("Pauta de votação")
                .build();
    }

    public static PautaRequestDTO criarPautaRequestDto() {
        return PautaRequestDTO.builder()
                .descricao("Pauta de votação")
                .build();
    }

    public static List<PautaEntity> criarListaEntity() {
        return singletonList(criarPautaEntity());
    }

    public static List<PautaResponseDTO> criarListaResponseDto() {
        return singletonList(criarPautaResponseDto());
    }
}
