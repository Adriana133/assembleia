package com.desafio.assembleia.controller;

import com.desafio.assembleia.business.VotacaoBusiness;
import com.desafio.assembleia.dto.VotacaoRequestDTO;
import com.desafio.assembleia.dto.VotacaoResponseDTO;
import com.desafio.assembleia.entity.VotacaoId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
