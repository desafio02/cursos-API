package com.cursosapi.cursos.service;

import com.cursosapi.cursos.exception.ExcecaoNomeCursoJaExistente;
import com.cursosapi.cursos.exception.Excecao_ID_Invalido;
import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.entity.Curso;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(Curso curso) {
        if (cursoRepository.existsByNome(curso.getNome())) {
            throw new ExcecaoNomeCursoJaExistente(String.format("Curso com nome já existente"));
        }
        return cursoRepository.save(curso);
    }

    public Curso alterarProfessor(Long idCurso, String novoNome) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new Excecao_ID_Invalido(String.format("Curso com id não existente")));
        curso.setProfessor(novoNome);
        return cursoRepository.save(curso);
    }

    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorNome(String nome) {
        return cursoRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}
