package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RelatorioVotosDTO {

    @JsonProperty(value = "quantidade_votos_sim")
    private long quantidadeVotosSim;

    @JsonProperty(value = "quantidade_votos_nao")
    private long quantidadeVotosNao;
}
