package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    public VotacaoEntity votar(VotacaoEntity entity) {
        return repository.save(entity);
    }

}
