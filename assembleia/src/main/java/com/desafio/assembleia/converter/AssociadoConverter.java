package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.AssociadoRequestDTO;
import com.desafio.assembleia.dto.AssociadoResponseDTO;
import com.desafio.assembleia.entity.AssociadoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociadoConverter {

        public AssociadoResponseDTO toResponseDto(AssociadoEntity entity) {
            return AssociadoResponseDTO.builder()
                    .id(entity.getId())
                    .cpf(entity.getCpf())
                    .nome(entity.getNome())
                    .build();
        }

        public AssociadoEntity requestDtoToEntity(AssociadoRequestDTO request) {
            return AssociadoEntity.builder()
                    .cpf(request.getCpf())
                    .nome(request.getNome())
                    .build();
        }

        public List<AssociadoResponseDTO> toListDto(List<AssociadoEntity> listEntity) {
            return listEntity.stream().map(this::toResponseDto).collect(Collectors.toList());
        }
}
