package com.desafio.assembleia.service;

import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.exception.NotFoundException;
import com.desafio.assembleia.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaRepository repository;

    public PautaEntity salvar(PautaEntity entity) {
        return repository.save(entity);
    }

    public List<PautaEntity> listar() {
        return repository.findAll();
    }

    public PautaEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Pauta %d não existe", id)));
    }

    public PautaEntity atualizar(PautaEntity entity, Long id) {
        buscarPorId(id);
        entity.setId(id);
        return salvar(entity);
    }

    public void excluirPorId(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
