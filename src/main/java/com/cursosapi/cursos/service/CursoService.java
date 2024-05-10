package com.cursosapi.cursos.service;

import com.cursosapi.cursos.exception.ExcecaoAreaConhecimentoInvalida;
import com.cursosapi.cursos.exception.ExcecaoNomeCursoJaExistente;
import com.cursosapi.cursos.exception.Excecao_ID_Invalido;
import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.entity.Curso;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(Curso curso) {
        if (cursoRepository.existsByNome(curso.getNome())) {
            throw new ExcecaoNomeCursoJaExistente("Curso com nome já existente");
        }

        if (!validarAreaConhecimento(curso.getAreaConhecimento())) {
            throw new ExcecaoAreaConhecimentoInvalida("Área de conhecimento inválida");
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

    private boolean validarAreaConhecimento(Curso.AreaConhecimento areaConhecimento) {
        for (Curso.AreaConhecimento enumValue : Curso.AreaConhecimento.values()) {
            if (enumValue.equals(areaConhecimento)) {
                return true;
            }
        }
        return false;
    }
}
