package com.desafio.assembleia.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class VotacaoId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private AssociadoEntity associado;

    @ManyToOne(fetch = FetchType.LAZY)
    private SessaoEntity sessao;
}
