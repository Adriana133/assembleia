package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessaoService {

    private final SessaoRepository repository;

    public SessaoEntity criar(SessaoEntity entity) {
        return repository.save(entity);
    }

    public SessaoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Sessao %d não existe", id)));
    }
}

