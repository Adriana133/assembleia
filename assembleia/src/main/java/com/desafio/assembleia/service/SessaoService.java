package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SessaoEntity> buscarPorStatus(int status) {
        return repository.findByStatus(status);
    }

    public List<SessaoEntity> buscarPorPauta(PautaEntity pauta) {
        return repository.findByPauta(pauta);
    }

    public SessaoEntity atualizar(SessaoEntity entity, Long id) {
        buscarPorId(id);
        entity.setId(id);
        return criar(entity);
    }

    public List<SessaoEntity> listarSessao() {
        return repository.findAll();
    }
}


