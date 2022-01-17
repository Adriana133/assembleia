package com.desafio.assembleia.controller;

import com.desafio.assembleia.converter.PautaConverter;
import com.desafio.assembleia.dto.PautaRequestDTO;
import com.desafio.assembleia.dto.PautaResponseDTO;
import com.desafio.assembleia.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pauta")
@RequiredArgsConstructor
public class PautaController {

    private final PautaService service;
    private final PautaConverter converter;

    @PostMapping
    public ResponseEntity<PautaResponseDTO> salvar(@RequestBody @Valid PautaRequestDTO request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.toResponseDTO(
                        service.salvar(converter.requestDtoToEntity(request))));
    }

    @GetMapping
    public ResponseEntity<List<PautaResponseDTO>> listar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toListDto(service.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toResponseDTO(
                        service.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PautaResponseDTO> atualizar(@RequestBody @Valid PautaRequestDTO request,
                                                      @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(converter.toResponseDTO(
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
