package com.desafio.assembleia.controller;

import com.desafio.assembleia.business.VotacaoBusiness;
import com.desafio.assembleia.dto.RelatorioVotosDTO;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/votacao")
@RequiredArgsConstructor
public class VotacaoController {

    private final VotacaoBusiness business;

    @PostMapping
    public ResponseEntity<VotacaoResponseDTO> votar(@RequestBody @Valid VotacaoRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(business.votar(request));
    }

    @GetMapping("/sessoes/{idSessao}/relatorio")
    public ResponseEntity<RelatorioVotosDTO> calcularVotosDaSessao(@PathVariable Long idSessao) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(business.calcularVotosDaSessao(idSessao));
    }

    @GetMapping("/sessoes/{idSessao}")
    public ResponseEntity<List<VotacaoResponseDTO>> listarVotosPorIdSessao(@PathVariable Long idSessao) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(business.listarPorIdSessao(idSessao));
    }
}
