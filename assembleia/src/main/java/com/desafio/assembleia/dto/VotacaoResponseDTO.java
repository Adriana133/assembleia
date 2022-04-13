package com.desafio.assembleia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class VotacaoResponseDTO {

    private VotacaoIdDTO id;
    private String voto;
    private AssociadoResponseDTO associado;
    private SessaoResponseDTO sessao;
}
