package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.SessaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.desafio.assembleia.utils.SessaoUtils.criarSessaoEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessaoServiceTest {

    @InjectMocks
    private SessaoService service;

    @Mock
    private SessaoRepository repository;

    @Test
    void quandoCriar_retornaSucesso() {

        SessaoEntity entity = criarSessaoEntity();

        when(repository.save(any(SessaoEntity.class)))
                .thenReturn(entity);

        assertThat(service.criar(entity)).isNotNull().isEqualTo(entity);
    }

    @Test
    void quandoBuscarPorId_retornaSucesso() {

        SessaoEntity entity = criarSessaoEntity();
        Long id = anyLong();

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        assertThat(service.buscarPorId(id))
                .isNotNull()
                .isEqualTo(entity);
    }

    @Test
    void quandoBuscarPorId_comIdInexistente_retornaErro() {

        Long id = anyLong();

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.buscarPorId(id))
                .isInstanceOf(NotFoundException.class)
                .hasMessage(String.format("Sessao %d não existe", id));
    }
}