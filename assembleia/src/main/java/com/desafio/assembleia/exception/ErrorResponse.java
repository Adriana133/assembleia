package com.desafio.assembleia.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final int status;
    private final String title;
    private final List<ErrorObject> errors;
}
