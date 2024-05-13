package com.cursosapi.cursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcecaoAreaConhecimentoInvalida extends  RuntimeException {
    public ExcecaoAreaConhecimentoInvalida (String message){
        super(message);
    }
}
