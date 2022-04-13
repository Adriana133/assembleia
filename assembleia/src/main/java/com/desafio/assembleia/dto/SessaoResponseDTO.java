package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class SessaoResponseDTO {

    private Long id;
    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonProperty(value = "data_inicial")
    private LocalDateTime dataInicial;

    @JsonProperty(value = "id_pauta")
    private Long idPauta;
}
