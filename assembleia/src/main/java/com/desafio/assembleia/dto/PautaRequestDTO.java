package com.desafio.assembleia.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PautaRequestDTO {

    @NotBlank(message = "o campo descricao é obrigatório")
    private String descricao;
}
