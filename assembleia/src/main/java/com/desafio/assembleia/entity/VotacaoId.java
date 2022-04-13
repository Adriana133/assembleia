package com.desafio.assembleia.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class VotacaoId implements Serializable {

    @Column(name = "id_associado")
    private Long idassociado;

    @Column(name = "id_sessao")
    private Long idsessao;
}
