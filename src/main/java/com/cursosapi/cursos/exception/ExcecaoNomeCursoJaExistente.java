package com.cursosapi.cursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcecaoNomeCursoJaExistente extends RuntimeException {
    private String nome;

    public ExcecaoNomeCursoJaExistente(String nomeCurso) {
        this.nome = nomeCurso;
    }

    public String getNome() {
        return nome;
    }
}