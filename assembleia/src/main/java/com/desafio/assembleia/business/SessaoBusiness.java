package com.desafio.assembleia.business;

import com.desafio.assembleia.converter.SessaoConverter;
import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.service.PautaService;
import com.desafio.assembleia.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.desafio.assembleia.enums.StatusEnum.ABERTA;

@Component
@RequiredArgsConstructor
public class SessaoBusiness {

    private final SessaoService service;
    private final SessaoConverter converter;
    private final PautaService pautaService;

    public SessaoResponseDTO criar(SessaoRequestDTO requestDTO) {

        SessaoEntity entity = converter.requestDtoToEntity(requestDTO);
        entity.setPauta(pautaService.buscarPorId(requestDTO.getIdPauta()));
        entity.setStatus(ABERTA.getId());

        return converter.toResponseDto(service.criar(entity));
    }

    public SessaoResponseDTO buscarPorId(Long id) {
        return converter.toResponseDto(service.buscarPorId(id));
    }

}
