package com.desafio.assembleia.utils;

import com.desafio.assembleia.dto.AssociadoRequestDTO;
import com.desafio.assembleia.dto.AssociadoResponseDTO;
import com.desafio.assembleia.entity.AssociadoEntity;

import java.util.List;

import static java.util.Collections.singletonList;

public abstract class AssociadoUtils {

    public static AssociadoEntity criarAssociadoEntity() {
        return AssociadoEntity.builder()
                .id(1L)
                .cpf("99623161034")
                .nome("Ana")
                .build();
    }

    public static AssociadoResponseDTO criarAssociadoResponseDto() {
        return AssociadoResponseDTO.builder()
                .id(1L)
                .cpf("99623161034")
                .nome("Ana")
                .build();
    }

    public static AssociadoRequestDTO criarAssociadoRequestDto() {
        return AssociadoRequestDTO.builder()
                .cpf("99623161034")
                .nome("Ana")
                .build();
    }

    public static List<AssociadoEntity> criarListAssociadoEntity() {
        return singletonList(criarAssociadoEntity());
    }

    public static List<AssociadoResponseDTO> criarListAssociadoResponseDto() {
        return singletonList(criarAssociadoResponseDto());
    }

}
