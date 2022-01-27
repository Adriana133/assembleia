package com.desafio.assembleia.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {

    ABERTA(1, "aberta"),
    FECHADA(2, "fechada");

    private final int id;
    private final String descricao;

    public static String getDescricao(int id) {
        Optional<StatusEnum> op = Stream.of(values())
                .filter(status -> status.id == id)
                .findFirst();

        return op.isPresent() ? op.get().getDescricao() : "";
    }
}
