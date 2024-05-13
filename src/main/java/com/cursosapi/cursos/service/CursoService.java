package com.cursosapi.cursos.service;

import com.cursosapi.cursos.exception.ExcecaoAreaConhecimentoInvalida;
import com.cursosapi.cursos.exception.ExcecaoBuscarComNomeInvalido;
import com.cursosapi.cursos.exception.ExcecaoNomeCursoJaExistente;
import com.cursosapi.cursos.exception.Excecao_ID_Invalido;
import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.entity.Curso;



import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
        try {
            Curso.AreaConhecimento.valueOf(curso.getAreaConhecimento().name());
        } catch (IllegalArgumentException e) {
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

    public Curso buscarPorNome(String nome) {
        return cursoRepository.findByNome(nome)
                .orElseThrow(() -> new ExcecaoBuscarComNomeInvalido("Curso não encontrado"));
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new Excecao_ID_Invalido("Curso não encontrado"));
    }

    public Curso inativarPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new Excecao_ID_Invalido(String.format("Curso com id não existente")));
        if(curso.isAtivo()) {
            curso.setAtivo(false);
        } else if (!curso.isAtivo()){
            curso.setAtivo(true);
        }
        return cursoRepository.save(curso);
    }

}
