package com.desafio.assembleia.converter;

import com.desafio.assembleia.entity.AssociadoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.AssociadoUtils.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AssociadoConverterTest {

    @InjectMocks
    private AssociadoConverter converter;

    @Test
    void quandoConverterToResponseDto_retornaSucesso() {

        assertEquals(criarAssociadoResponseDto(), converter.toResponseDto(criarAssociadoEntity()));
    }

    @Test
    void quandoConverterRequestDtoToEntity_RetornaSucesso() {

        AssociadoEntity entity = criarAssociadoEntity();
        AssociadoEntity entityConvertida = converter.requestDtoToEntity(criarAssociadoRequestDto());

        assertAll(
                () -> assertEquals(entity.getCpf(), entityConvertida.getCpf()),
                () -> assertEquals(entity.getNome(), entityConvertida.getNome())
        );
    }

    @Test
    void quandoConverterToListDto_retornaSucesso() {

        assertEquals(criarListAssociadoResponseDto(), converter.toListDto(criarListAssociadoEntity()));
    }
}