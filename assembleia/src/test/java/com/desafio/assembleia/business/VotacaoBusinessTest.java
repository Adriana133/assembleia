package com.desafio.assembleia.business;

import com.desafio.assembleia.converter.VotacaoConverter;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.enums.StatusEnum;
import com.desafio.assembleia.service.AssociadoService;
import com.desafio.assembleia.service.SessaoService;
import com.desafio.assembleia.service.VotacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.AssociadoUtils.criarAssociadoEntity;
import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoEntity;
import static com.desafio.assembleia.utils.VotacaoUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VotacaoBusinessTest {

    @InjectMocks
    private VotacaoBusiness business;

    @Mock
    private VotacaoConverter converter;

    @Mock
    private VotacaoService service;

    @Mock
    private SessaoService sessaoService;

    @Mock
    private AssociadoService associadoService;

    @Test
    void quandoVotar_retornaSucesso() {

        VotacaoRequestDTO requestDto = criarVotacaoRequestDto();
        VotacaoEntity entity = criarVotacaoEntity();
        VotacaoResponseDTO responseDto = criarVotacaoResponseDto();
        SessaoEntity sessaoEntity = criarSessaoEntity();
        Long id = anyLong();

        when(converter.requestDtoToEntity(requestDto))
                .thenReturn(entity);
        when(associadoService.buscarPorId(id))
                .thenReturn(criarAssociadoEntity());
        when(sessaoService.buscarPorId(id))
                .thenReturn(sessaoEntity);
        when(converter.toResponseDto(any(VotacaoEntity.class)))
                .thenReturn(responseDto);
        when(service.votar(any(VotacaoEntity.class)))
                .thenReturn(entity);

        assertThat(business.votar(requestDto))
                .isNotNull()
                .isInstanceOf(VotacaoResponseDTO.class)
                .isEqualTo(responseDto);
    }
}