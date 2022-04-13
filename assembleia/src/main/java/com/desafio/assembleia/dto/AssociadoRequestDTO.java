package com.desafio.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AssociadoRequestDTO {

    @JsonProperty(value = "cpf")
    @NotBlank(message = "o campo cpf é obrigatório")
    @Size(min = 11, max = 11)
    @CPF(message = "cpf inválido")
    private String cpf;
    private String nome;

}
