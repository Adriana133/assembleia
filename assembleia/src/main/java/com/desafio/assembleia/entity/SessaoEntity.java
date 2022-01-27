package com.desafio.assembleia.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "sessao")
public class SessaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SESSAO_SEQUENCE")
    @SequenceGenerator(name = "ID_SESSAO_SEQUENCE", sequenceName = "ID_SESSAO", allocationSize = 1)
    private Long id;

    private int status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAUTA")
    private PautaEntity pauta;

    @OneToMany(mappedBy = "id.sessao")
    private Collection<VotacaoEntity> votacaoEntitiesList;
}
