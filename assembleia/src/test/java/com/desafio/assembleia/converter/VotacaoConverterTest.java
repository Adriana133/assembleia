package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.VotacaoUtils.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VotacaoConverterTest {

    @InjectMocks
    private VotacaoConverter converter;

    @Test
    void quandoConverterRequestDtoToEntity_retornaSucesso() {

        VotacaoEntity entity = criarVotacaoEntity();
        VotacaoEntity entityConvertida = converter.requestDtoToEntity(criarVotacaoRequestDto());

        assertAll(
                () -> assertEquals(entity.getVoto(), entityConvertida.getVoto()),
                () -> assertEquals(entity.getId().getIdassociado(), entityConvertida.getId().getIdassociado()),
                () -> assertEquals(entity.getId().getIdsessao(), entityConvertida.getId().getIdsessao())
        );
    }

    @Test
    void quandoConverterToResponseDto_retornaSucesso() {

        VotacaoResponseDTO responseDto = criarVotacaoResponseDto();
        VotacaoResponseDTO responseDtoConvertido = converter.toResponseDto(criarVotacaoEntity());

        assertAll(
                () -> assertEquals(responseDto.getVoto(), responseDtoConvertido.getVoto())
        );
    }
}