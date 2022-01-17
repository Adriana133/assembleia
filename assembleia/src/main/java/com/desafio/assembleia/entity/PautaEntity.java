package com.desafio.assembleia.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "pauta")
public class PautaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID-SEQUENCE")
    @SequenceGenerator(name = "ID-SEQUENCE", sequenceName = "ID_PAUTA", allocationSize = 1)
    private Long id;
    private String descricao;
}
