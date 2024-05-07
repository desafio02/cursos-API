package com.cursosapi.cursos.web;

import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.entity.Curso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public record CursoController(CursoService cursoService) {

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso){
        return cursoService.cadastrar(curso);
    }
}
