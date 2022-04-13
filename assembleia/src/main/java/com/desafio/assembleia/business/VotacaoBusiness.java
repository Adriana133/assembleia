package com.desafio.assembleia.business;

import com.desafio.assembleia.converter.VotacaoConverter;
import com.desafio.assembleia.dto.RelatorioVotosDTO;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.AssociadoEntity;
import com.desafio.assembleia.entity.SessaoEntity;
import com.desafio.assembleia.entity.VotacaoEntity;
import com.desafio.assembleia.entity.VotacaoId;
import com.desafio.assembleia.enums.StatusEnum;
import com.desafio.assembleia.exception.ErrorBusinessException;
import com.desafio.assembleia.service.AssociadoService;
import com.desafio.assembleia.service.SessaoService;
import com.desafio.assembleia.service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import static com.desafio.assembleia.enums.VotoEnum.SIM;

@Component
@RequiredArgsConstructor
public class VotacaoBusiness {

    private final VotacaoService service;
    private final VotacaoConverter converter;
    private final AssociadoService associadoService;
    private final SessaoService sessaoService;

    @Scheduled(fixedRate = 60000)
    public void verificarDataExpiracao() {

        List<SessaoEntity> sessoesAbertas = sessaoService.buscarPorStatus(StatusEnum.ABERTA.getId());
        for (SessaoEntity sessao : sessoesAbertas) {

            LocalDateTime dataInicial = sessao.getDataInicial();
            LocalDateTime dataExpiracao = dataInicial.plus(Duration.of(1L, ChronoUnit.HOURS));

            if (LocalDateTime.now().isAfter(dataExpiracao)) {
                sessao.setStatus(StatusEnum.FECHADA.getId());
                sessaoService.atualizar(sessao, sessao.getId());
            }
        }
    }

    public VotacaoResponseDTO votar(VotacaoRequestDTO requestDTO) {

        VotacaoEntity entity = converter.requestDtoToEntity(requestDTO);
        SessaoEntity sessao = sessaoService.buscarPorId(entity.getSessao().getId());
        VotacaoId votacaoId = entity.getId();
        AssociadoEntity associadoEntity = associadoService.buscarPorId(entity.getAssociado().getId());

        validarSeAssociadoJaVotouNessaSessao(votacaoId);

        if (sessao != null && sessao.getStatus() == StatusEnum.ABERTA.getId()) {
            votacaoId.setIdassociado(associadoEntity.getId());
            votacaoId.setIdsessao(entity.getId().getIdsessao());
            entity.setVoto(requestDTO.getVoto());
            entity.setId(votacaoId);

            return converter.toResponseDto(service.votar(entity));
        } else {
            throw new ErrorBusinessException("Votação para esta sessão já está encerrada!");
        }
    }

    private void validarSeAssociadoJaVotouNessaSessao(VotacaoId votoId) {
        service.buscarPorId(votoId)
                .ifPresent(voto -> {
                    VotacaoId id = voto.getId();
                    throw new ErrorBusinessException(
                            String.format("Associado %d já votou na sessão %d",
                                    id.getIdassociado(),
                                    id.getIdsessao()));
                });
    }

    public RelatorioVotosDTO calcularVotosDaSessao(Long idSessao) {
        SessaoEntity sessaoEntity = carregarSessaoEntity(idSessao);

        List<VotacaoResponseDTO> votos = listarPorIdSessao(idSessao);
        long quantidadeVotosSim = votos.stream()
                .filter(voto -> Objects.equals(SIM.name(), voto.getVoto()))
                .count();
        long quantidadeVotosNao = votos.size() - quantidadeVotosSim;

        return new RelatorioVotosDTO(quantidadeVotosSim, quantidadeVotosNao);
    }

    private SessaoEntity carregarSessaoEntity(Long idSessao) {
        return sessaoService.buscarPorId(idSessao);
    }

    public List<VotacaoResponseDTO> listarPorIdSessao(Long idSessao) {
        return converter.toListDto(service.listarPorIdSessao(idSessao));
    }
}
