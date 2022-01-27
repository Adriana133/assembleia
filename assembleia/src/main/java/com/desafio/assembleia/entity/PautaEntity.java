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
@Table(name = "pauta")
public class PautaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PAUTA_SEQUENCE")
    @SequenceGenerator(name = "ID_PAUTA_SEQUENCE", sequenceName = "ID_PAUTA", allocationSize = 1)
    private Long id;
    private String descricao;
}
