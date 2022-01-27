package com.desafio.assembleia.utils;

import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.*;
import com.desafio.assembleia.enums.VotoEnum;

import java.util.Collections;

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
                        .associado(AssociadoEntity.builder()
                                .id(1L)
                                .cpf("99623161034")
                                .nome("Ana")
                                .votacaoEntitiesList(Collections.singleton(VotacaoEntity.builder().build()))
                                .build())
                        .sessao(SessaoEntity.builder()
                                .id(2L)
                                .status(1)
                                .pauta(PautaEntity.builder().id(1L).descricao("pauta de votação").build())
                                .votacaoEntitiesList(Collections.singleton(VotacaoEntity.builder().build()))
                                .build())
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
