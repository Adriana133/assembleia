package com.desafio.assembleia.controller;

import com.desafio.assembleia.business.SessaoBusiness;
import com.desafio.assembleia.dto.SessaoRequestDTO;
import com.desafio.assembleia.dto.SessaoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessao")
@RequiredArgsConstructor
public class SessaoController {

    private final SessaoBusiness business;

    @PostMapping
    public ResponseEntity<SessaoResponseDTO> criarSessao(@RequestBody @Valid SessaoRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(business.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessaoResponseDTO> buscarSessaoPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(business.buscarPorId(id));
    }

}
