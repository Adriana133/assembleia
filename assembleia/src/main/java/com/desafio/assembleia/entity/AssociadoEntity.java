package com.desafio.assembleia.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ASSOCIADO_SEQUENCE")
    @SequenceGenerator(name = "ID_ASSOCIADO_SEQUENCE", sequenceName = "ID_ASSOCIADO", allocationSize = 1)
    private Long id;
    private String cpf;
    private String nome;

    @OneToMany(mappedBy = "id.associado")
    private Collection<VotacaoEntity> votacaoEntitiesList;
}
