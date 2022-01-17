package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AssociadoRequestDTO {

    @JsonProperty(value = "cpf")
    @NotBlank(message = "o campo cpf é obrigatório")
    @CPF(message = "cpf inválido")
    private String cpf;
    private String nome;

}
