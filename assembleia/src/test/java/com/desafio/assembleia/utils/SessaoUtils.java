package com.desafio.assembleia.utils;

import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;

import java.util.Collections;

public abstract class SessaoUtils {

    public static SessaoRequestDTO criarSessaoRequestDto() {
        return SessaoRequestDTO.builder()
                .idPauta(1L)
                .build();
    }

    public static SessaoEntity criarSessaoEntity() {
        return SessaoEntity.builder()
                .id(1L)
                .status(1)
                .pauta(PautaEntity.builder()
                        .id(1L)
                        .descricao("pauta de votação")
                        .build())
                .build();
    }

    public static SessaoResponseDTO criarSessaoResponseDto() {
        return SessaoResponseDTO.builder()
                .id(1L)
                .status("aberta")
                .idPauta(1L)
                .build();
    }
}
