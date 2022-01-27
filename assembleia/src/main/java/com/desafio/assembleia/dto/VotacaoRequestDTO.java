package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VotacaoRequestDTO {

    @NotNull(message = "voto 1 - Sim e 2 - Não, é um campo obrigatório")
    private int voto;

    @NotNull(message = "id_associado é um campo obrigatório")
    @JsonProperty(value = "id_associado")
    private Long idAssociado;

    @NotNull(message = "id_sessao é um campo obrigatório")
    @JsonProperty(value = "id_sessao")
    private Long idSessao;
}
