package com.desafio.assembleia.repository;

import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacaoRepository extends JpaRepository<VotacaoEntity, VotacaoId> {

    @Query("from VotacaoEntity v " +
            "join fetch v.associado " +
            "join fetch v.sessao s " +
            "join fetch s.pauta " +
            "where v.sessao.id = :idSessao")
    List<VotacaoEntity> listarPorIdSessao(@Param("idSessao") Long idSessao);

}

