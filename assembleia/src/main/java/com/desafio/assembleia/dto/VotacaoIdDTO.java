package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class VotacaoIdDTO {

    @NotNull(message = "id_associado é um campo obrigatório")
    @JsonProperty(value = "id_associado")
    private Long idAssociado;

    @NotNull(message = "id_sessao é um campo obrigatório")
    @JsonProperty(value = "id_sessao")
    private Long idSessao;
}
