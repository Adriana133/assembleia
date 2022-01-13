package com.desafio.assembleia.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class AssociadoResponseDTO {

    private Long id;
    private String cpf;
    private String nome;
}
