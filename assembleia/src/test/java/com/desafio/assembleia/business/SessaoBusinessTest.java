package com.desafio.assembleia.business;

import com.desafio.assembleia.converter.SessaoConverter;
import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.service.PautaService;
import com.desafio.assembleia.service.SessaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.PautaUtils.criarPautaEntity;
import static com.desafio.assembleia.utils.SessaoUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessaoBusinessTest {

    @InjectMocks
    private SessaoBusiness business;

    @Mock
    private SessaoConverter converter;

    @Mock
    private SessaoService service;

    @Mock
    private PautaService pautaService;

    @Test
    void quandoCriar_retornaSucesso() {

        SessaoRequestDTO requestDto = criarSessaoRequestDto();
        SessaoEntity entity = criarSessaoEntity();
        SessaoResponseDTO responseDto = criarSessaoResponseDto();

        when(converter.requestDtoToEntity(requestDto))
                .thenReturn(entity);
        when(pautaService.buscarPorId(anyLong()))
                .thenReturn(criarPautaEntity());
        when(converter.toResponseDto(any(SessaoEntity.class)))
                .thenReturn(responseDto);
        when(service.criar(any(SessaoEntity.class)))
                .thenReturn(entity);

        assertThat(business.criar(requestDto))
                .isNotNull()
                .isInstanceOf(SessaoResponseDTO.class)
                .isEqualTo(responseDto);
    }

    @Test
    void quandoBuscarPorId_retornaSucesso() {

        SessaoResponseDTO responseDTO = criarSessaoResponseDto();
        SessaoEntity entity = criarSessaoEntity();
        Long id = entity.getId();

        when(converter.toResponseDto(any(SessaoEntity.class)))
                .thenReturn(responseDTO);
        when(service.buscarPorId(id))
                .thenReturn(entity);

        assertThat(business.buscarPorId(id))
                .isNotNull()
                .isEqualTo(responseDTO);
    }
}