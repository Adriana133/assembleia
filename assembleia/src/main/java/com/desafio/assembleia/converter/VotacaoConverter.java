package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.*;
import com.desafio.assembleia.enums.VotoEnum;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class VotacaoConverter {

    public VotacaoEntity requestDtoToEntity(VotacaoRequestDTO requestDTO) {
        return VotacaoEntity.builder()
                .voto(requestDTO.getVoto())
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

    public VotacaoResponseDTO toResponseDto(VotacaoEntity entity) {
        return VotacaoResponseDTO.builder()
                .idSessao(entity.getId().getSessao().getId())
                .idAssociado(entity.getId().getAssociado().getId())
                .voto(VotoEnum.getDescricao(entity.getVoto()))
                .build();
    }
}
