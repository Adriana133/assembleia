package com.desafio.assembleia.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "associado")
public class AssociadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID-SEQUENCE")
    @SequenceGenerator(name = "ID-SEQUENCE", sequenceName = "ID_ASSOCIADO", allocationSize = 1)
    private Long id;
    private String cpf;
    private String nome;

}
