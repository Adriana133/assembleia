package com.desafio.assembleia.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class AssociadoResponseDTO {

    private Long id;
    private String cpf;
    private String nome;
}
