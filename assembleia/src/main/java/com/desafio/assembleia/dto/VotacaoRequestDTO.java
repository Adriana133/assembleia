package com.desafio.assembleia.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VotacaoRequestDTO {

    @Valid
    private VotacaoIdDTO id;

    @NotNull(message = "voto 1 - Sim e 2 - Não, é um campo obrigatório")
    private int voto;
}
