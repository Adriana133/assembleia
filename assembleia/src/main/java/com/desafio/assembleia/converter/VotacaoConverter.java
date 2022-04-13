package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.enums.VotoEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotacaoConverter {

    public VotacaoEntity requestDtoToEntity(VotacaoRequestDTO requestDTO) {
        return VotacaoEntity.builder()
                .voto(requestDTO.getVoto())
                .id(VotacaoId.builder()
                        .idassociado(requestDTO.getIdAssociado())
                        .idsessao(requestDTO.getIdSessao())
                        .build())
                .build();
    }

    public VotacaoResponseDTO toResponseDto(VotacaoEntity entity) {
        return VotacaoResponseDTO.builder()
                .idSessao(entity.getSessao().getId())
                .idAssociado(entity.getAssociado().getId())
                .voto(VotoEnum.getDescricao(entity.getVoto()))
                .build();
    }

    public List<VotacaoResponseDTO> toListDto(List<VotacaoEntity> listEntity) {
        return listEntity.stream().map(this::toResponseDto).collect(Collectors.toList());
    }
}
