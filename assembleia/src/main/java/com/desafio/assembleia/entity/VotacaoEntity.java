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
@Table(name = "votacao")
public class VotacaoEntity {

    @EmbeddedId
    private VotacaoId id;

    private int voto;
}
