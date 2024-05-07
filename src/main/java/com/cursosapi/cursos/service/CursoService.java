package com.cursosapi.cursos.service;

import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(Curso curso){
        return cursoRepository.save(curso);
    }

    @Transactional
    public Curso alterarProfessor(Long idCurso, String novoNome) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + idCurso));
        curso.setProfessor(novoNome);
        return cursoRepository.save(curso);
    }
}
