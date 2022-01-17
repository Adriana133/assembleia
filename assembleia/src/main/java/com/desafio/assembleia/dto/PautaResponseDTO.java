package com.desafio.assembleia.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class PautaResponseDTO {

    private Long id;
    private String descricao;
}
