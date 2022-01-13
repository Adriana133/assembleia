package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.AssociadoEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository repository;

    public AssociadoEntity salvar(AssociadoEntity entity) {
        return repository.save(entity);
    }

    public List<AssociadoEntity> listar() {
        return repository.findAll();
    }

    public AssociadoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Associado %d não existe", id)));
    }

    public AssociadoEntity atualizar(AssociadoEntity entity, Long id) {
        buscarPorId(id);
        entity.setId(id);
        return salvar(entity);
    }

    public void excluirPorId(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public void excluirTodos() {
        repository.deleteAll();
    }
}
