package com.desafio.assembleia.converter;

import com.desafio.assembleia.entity.PautaEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.PautaUtils.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PautaConverterTest {

    @InjectMocks
    private PautaConverter converter;

    @Test
    void quandoConverterToResponseDTO_retornaSucesso() {

        assertEquals(criarPautaResponseDto(), converter.toResponseDTO(criarPautaEntity()));
    }

    @Test
    void quandoConverterRequestDtoToEntity_retornaSucesso() {

        PautaEntity entity = criarPautaEntity();
        PautaEntity entityConvertida = converter.requestDtoToEntity(criarPautaRequestDto());

        assertAll(
                () -> assertEquals(entity.getDescricao(), entityConvertida.getDescricao())
        );
    }

    @Test
    void quandoConverterToListDto_retornaSucesso() {

        assertEquals(criarListaResponseDto(), converter.toListDto(criarListaEntity()));
    }
}