package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.PautaRequestDTO;
import com.desafio.assembleia.dto.PautaResponseDTO;
import com.desafio.assembleia.entity.PautaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PautaConverter {

    public PautaResponseDTO toResponseDTO(PautaEntity entity) {
        return PautaResponseDTO.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .build();
    }

    public PautaEntity requestDtoToEntity(PautaRequestDTO request) {
        return PautaEntity.builder()
                .descricao(request.getDescricao())
                .build();
    }

    public List<PautaResponseDTO> toListDto(List<PautaEntity> entityList) {
        return entityList.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
