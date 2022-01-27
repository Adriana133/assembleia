package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
public class SessaoConverter {

    public SessaoEntity requestDtoToEntity(SessaoRequestDTO requestDTO) {
        return SessaoEntity.builder()
                .pauta(PautaEntity.builder()
                        .id(requestDTO.getIdPauta())
                        .build())
                .build();
    }

    public SessaoResponseDTO toResponseDto(SessaoEntity entity) {
        return SessaoResponseDTO.builder()
                .id(entity.getId())
                .idPauta(entity.getPauta().getId())
                .status(StatusEnum.getDescricao(entity.getStatus()))
                .build();
    }
}
