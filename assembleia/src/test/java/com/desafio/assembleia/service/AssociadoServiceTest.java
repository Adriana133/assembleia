package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.AssociadoEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.AssociadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.desafio.assembleia.utils.AssociadoUtils.criarAssociadoEntity;
import static com.desafio.assembleia.utils.AssociadoUtils.criarListAssociadoEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {

    @InjectMocks
    private AssociadoService service;

    @Mock
    private AssociadoRepository repository;

    @Test
    void quandoSalvar_retornaSucesso() {

        AssociadoEntity entity = criarAssociadoEntity();

        when(repository.save(any(AssociadoEntity.class)))
                .thenReturn(entity);

        assertThat(service.salvar(entity)).isNotNull().isEqualTo(entity);
    }

    @Test
    void quandoListar_retornaSucesso() {

        when(repository.findAll()).thenReturn(criarListAssociadoEntity());

        assertThat(service.listar())
                .isNotNull()
                .hasSize(1);
    }

    @Test
    void quandoBuscarPorId_retornaSucesso() {

        AssociadoEntity entity = criarAssociadoEntity();
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
                .hasMessage(String.format("Associado %d não existe", id));
    }

    @Test
    void quandoAtualizar_retornaSucesso() {

        AssociadoEntity entity = criarAssociadoEntity();
        Long id = anyLong();

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(repository.save(any(AssociadoEntity.class))).thenReturn(entity);

        assertThat(service.atualizar(entity, id))
                .isNotNull()
                .isEqualTo(entity);
    }

    @Test
    void quandoExcluirPorId_retornaSucesso() {

        AssociadoEntity entity = criarAssociadoEntity();

        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        service.excluirPorId(entity.getId());
        verify(repository).deleteById(entity.getId());
    }
}