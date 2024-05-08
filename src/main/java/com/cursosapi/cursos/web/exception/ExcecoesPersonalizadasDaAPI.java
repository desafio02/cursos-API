package com.cursosapi.cursos.web.exception;

import com.cursosapi.cursos.exception.ExcecaoNomeCursoJaExistente;
import com.cursosapi.cursos.exception.Excecao_ID_Invalido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExcecoesPersonalizadasDaAPI extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExcecaoNomeCursoJaExistente.class)
    public final ResponseEntity<Object> handleExcecaoNomeCursoJaExistente(ExcecaoNomeCursoJaExistente ex, WebRequest request) {
        String mensagemErro = "[ERRO]Já existe um curso com o nome: "+ex.getNome();
        return handleExceptionInternal(ex, mensagemErro, null, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(Excecao_ID_Invalido.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String handleExcecao_ID_Invalido(Excecao_ID_Invalido ex) {
        return "[ERRO]Curso com o id: "+ ex.getId() +" não existe!";
    }
}

