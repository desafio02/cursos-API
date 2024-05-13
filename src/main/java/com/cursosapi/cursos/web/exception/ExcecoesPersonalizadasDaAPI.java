package com.cursosapi.cursos.web.exception;

import com.cursosapi.cursos.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExcecoesPersonalizadasDaAPI extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExcecaoNomeCursoJaExistente.class)
    public final ResponseEntity<MensagemErro> handleExcecaoNomeCursoJaExistente(ExcecaoNomeCursoJaExistente ex, HttpServletRequest request) {
        log.error("Erro na API", ex);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MensagemErro(request, HttpStatus.CONFLICT, ex.getMessage()));
    }

    @ExceptionHandler(Excecao_ID_Invalido.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<MensagemErro> handleExcecao_ID_Invalido(Excecao_ID_Invalido ex, HttpServletRequest request) {
        log.error("Api Error", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MensagemErro(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(ExcecaoAreaConhecimentoInvalida.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<MensagemErro> handleExcecaoAreaConhecimentoInvalida(ExcecaoAreaConhecimentoInvalida ex, HttpServletRequest request) {
        log.error("Erro na API", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MensagemErro(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(ExcecaoBuscarComNomeInvalido.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<MensagemErro> handleExcecaoBuscarComNomeInvalido(ExcecaoBuscarComNomeInvalido ex, HttpServletRequest request) {
        log.error("Erro na API", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MensagemErro(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

}

