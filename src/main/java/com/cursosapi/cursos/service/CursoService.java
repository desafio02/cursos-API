package com.cursosapi.cursos.service;

import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.entity.Curso;
import org.springframework.stereotype.Service;

@Service
public record CursoService(CursoRepository cursoRepository) {

    public Curso cadastrar(Curso curso){
        return cursoRepository.save(curso);
    }


}
