package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class VotacaoResponseDTO {

    private String voto;

    @JsonProperty(value = "id_associado")
    private Long idAssociado;

    @JsonProperty(value = "id_sessao")
    private Long idSessao;
}
