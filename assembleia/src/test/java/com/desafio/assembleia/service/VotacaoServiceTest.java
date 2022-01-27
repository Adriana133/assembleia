package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.repository.VotacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafio.assembleia.utils.VotacaoUtils.criarVotacaoEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VotacaoServiceTest {

    @InjectMocks
    private VotacaoService service;

    @Mock
    private VotacaoRepository repository;

    @Test
    void quandoVotar_retornaSucesso() {

        VotacaoEntity entity = criarVotacaoEntity();

        when(repository.save(any(VotacaoEntity.class)))
                .thenReturn(entity);

        assertThat(service.votar(entity)).isNotNull().isEqualTo(entity);
    }
}