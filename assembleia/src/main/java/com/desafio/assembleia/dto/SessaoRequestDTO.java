package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SessaoRequestDTO {

    @NotNull(message = "id_pauta é um campo obrigatório")
    @JsonProperty(value = "id_pauta")
    private Long idPauta;
}
