package com.cursosapi.cursos.exception;

public class Excecao_ID_Invalido extends RuntimeException {

    private final Long id;

    public Excecao_ID_Invalido(Long id) {
        super("Curso não encontrado com o ID: " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
