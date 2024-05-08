package com.cursosapi.cursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExcecaoNomeCursoJaExistente extends RuntimeException {

    public ExcecaoNomeCursoJaExistente(String message) {
        super(message);
    }
}