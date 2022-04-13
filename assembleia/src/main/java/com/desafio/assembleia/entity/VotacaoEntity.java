package com.desafio.assembleia.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "Votacao")
public class VotacaoEntity {

    @EmbeddedId
    private VotacaoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idAssociado")
    @JoinColumn(name = "id_associado")
    private AssociadoEntity associado;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSessao")
    @JoinColumn(name = "id_sessao")
    private SessaoEntity sessao;

    private int voto;
}
