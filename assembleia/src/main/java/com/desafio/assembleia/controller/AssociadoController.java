package com.desafio.assembleia.controller;


import com.desafio.assembleia.converter.AssociadoConverter;
import com.desafio.assembleia.dto.AssociadoRequestDTO;
import com.desafio.assembleia.dto.AssociadoResponseDTO;
import com.desafio.assembleia.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associado")
@RequiredArgsConstructor
public class AssociadoController {

    private final AssociadoConverter converter;
    private final AssociadoService service;

    @PostMapping
    public ResponseEntity<AssociadoResponseDTO> salvar(@RequestBody @Valid AssociadoRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.toResponseDto(
                        service.salvar(converter.requestDtoToEntity(request))));
    }

    @GetMapping
    public ResponseEntity<List<AssociadoResponseDTO>> listar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toListDto(service.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toResponseDto(
                        service.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociadoResponseDTO> atualizar(@RequestBody @Valid AssociadoRequestDTO request,
                                                          @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toResponseDto(
                        service.atualizar(converter.requestDtoToEntity(request), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirPorId(@PathVariable Long id) {
        service.excluirPorId(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity excluirTodos() {
        service.excluirTodos();
        return ResponseEntity.noContent().build();
    }
}
