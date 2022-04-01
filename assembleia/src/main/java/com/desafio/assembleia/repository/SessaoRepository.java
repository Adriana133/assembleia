package com.desafio.assembleia.repository;

import com.desafio.assembleia.entity.PautaEntity;
import com.desafio.assembleia.entity.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoEntity, Long> {

    List<SessaoEntity> findByStatus(int status);

    List<SessaoEntity> findByPauta(PautaEntity pauta);
}

