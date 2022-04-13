package com.desafio.assembleia.converter;

import com.desafio.assembleia.dto.AssociadoResponseDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.enums.VotoEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotacaoConverter {

    public VotacaoEntity requestDtoToEntity(VotacaoRequestDTO requestDTO) {
        return VotacaoEntity.builder()
                .voto(requestDTO.getVoto())
                .build();
    }

    public VotacaoResponseDTO toResponseDto(VotacaoEntity entity) {
        return VotacaoResponseDTO.builder()
                .sessao(SessaoResponseDTO.builder()
                        .id(1L)
                        .status("Fechada")
                        .dataInicial(LocalDateTime.now())
                        .idPauta(33L)
                        .build())
                .associado(AssociadoResponseDTO.builder()
                        .id(1L)
                        .cpf("99623161034")
                        .nome("adri")
                        .build())
                .voto(VotoEnum.getDescricao(entity.getVoto()))
                .build();
    }

    public List<VotacaoResponseDTO> toListDto(List<VotacaoEntity> listEntity) {
        return listEntity.stream().map(this::toResponseDto).collect(Collectors.toList());
    }
}
