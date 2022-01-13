package com.desafio.assembleia.exception.handler;

import com.desafio.assembleia.exception.ErrorResponse;
import com.desafio.assembleia.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.Collections.emptyList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String ERROR_TITLE = "Requisição possui campos inválidos";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        HttpStatus status = NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(status.value(), ex.getMessage(), emptyList());

        return ResponseEntity.status(status).body(errorResponse);
    }
}
