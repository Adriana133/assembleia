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
public class SessaoResponseDTO {

    private Long id;
    private String status;

    @JsonProperty(value = "id_pauta")
    private Long idPauta;
}
