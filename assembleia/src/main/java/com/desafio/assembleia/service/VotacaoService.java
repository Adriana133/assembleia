package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    public VotacaoEntity votar(VotacaoEntity entity) {
        return repository.save(entity);
    }

    public Optional<VotacaoEntity> buscarPorId(VotacaoId id) {
        return repository.findById(id);
    }

    public List<VotacaoEntity> listarPorIdSessao(Long idSessao) { return repository.listarPorIdSessao(idSessao);
    }
}
