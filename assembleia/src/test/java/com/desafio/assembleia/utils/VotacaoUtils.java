package com.desafio.assembleia.utils;

import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.enums.VotoEnum;

public abstract class VotacaoUtils {

    public static VotacaoRequestDTO criarVotacaoRequestDto() {
        return VotacaoRequestDTO.builder()
                .voto(1)
                .idSessao(2L)
                .idAssociado(1L)
                .build();
    }

    public static VotacaoEntity criarVotacaoEntity() {
        return VotacaoEntity.builder()
                .voto(VotoEnum.SIM.getId())
                .id(VotacaoId.builder()
                        .idassociado(1L)
                        .idsessao(2L)
                        .build())
                .build();
    }

    public static VotacaoResponseDTO criarVotacaoResponseDto() {
        return VotacaoResponseDTO.builder()
                .voto(VotoEnum.SIM.getDescricao())
                .idAssociado(1L)
                .idSessao(2L)
                .build();
    }
}
