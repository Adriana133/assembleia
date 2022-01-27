package com.desafio.assembleia.business;

import com.desafio.assembleia.converter.VotacaoConverter;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.service.AssociadoService;
import com.desafio.assembleia.service.SessaoService;
import com.desafio.assembleia.service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VotacaoBusiness {

    private final VotacaoService service;
    private final VotacaoConverter converter;
    private final AssociadoService associadoService;
    private final SessaoService sessaoService;

    public VotacaoResponseDTO votar(VotacaoRequestDTO requestDTO) {

        VotacaoEntity entity = converter.requestDtoToEntity(requestDTO);
        VotacaoId votacaoId = new VotacaoId();
        votacaoId.setAssociado(associadoService.buscarPorId(requestDTO.getIdAssociado()));
        votacaoId.setSessao(sessaoService.buscarPorId(requestDTO.getIdSessao()));
        entity.setVoto(requestDTO.getVoto());
        entity.setId(votacaoId);

        return converter.toResponseDto(service.votar(entity));
    }
}
