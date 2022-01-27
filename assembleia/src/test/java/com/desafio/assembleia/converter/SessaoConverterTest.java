package com.desafio.assembleia.converter;

import com.desafio.assembleia.entity.SessaoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.SessaoUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SessaoConverterTest {

    @InjectMocks
    private SessaoConverter converter;

    @Test
    void quandoConverterRequestDtoToEntity_retornaSucesso() {

        SessaoEntity entity = criarSessaoEntity();
        SessaoEntity entityConvertida = converter.requestDtoToEntity(criarSessaoRequestDto());

        assertAll(
                () -> assertEquals(entity.getPauta().getId(), entityConvertida.getPauta().getId())
        );
    }

    @Test
    void quandoConverterToResponseDto_retornaSucesso() {

        assertEquals(criarSessaoResponseDto(), converter.toResponseDto(criarSessaoEntity()));

    }
}