package com.desafio.assembleia.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorObject {

    private final String message;
    private final String field;
    private final Object value;

}
