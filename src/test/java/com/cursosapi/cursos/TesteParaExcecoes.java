package com.cursosapi.cursos;

import com.cursosapi.cursos.exception.ExcecaoBuscarComNomeInvalido;
import com.cursosapi.cursos.exception.Excecao_ID_Invalido;
import com.cursosapi.cursos.repository.CursoRepository;
import com.cursosapi.cursos.service.CursoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TesteParaExcecoes {

    private CursoService cursoService;
    private CursoRepository cursoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cursoRepository = Mockito.mock(CursoRepository.class);
        cursoService = new CursoService(cursoRepository);
    }

    @Test
    public void testExcecaoBuscarCursoCom_ID_Invalido() {
        Long idCurso = 0L;
        when(cursoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(Excecao_ID_Invalido.class, () -> cursoService.buscarPorId(idCurso));
    }
    @Test
    public void testExcecaoBuscarCursoComNomeInvalido() {
        String nome = ("xxxxxxxxxxxxxxxxxxx");
        when(cursoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ExcecaoBuscarComNomeInvalido.class, () -> cursoService.buscarPorNome(nome));
    }

    @Test
    public void testExcecaoAlterarProfessorCom_ID_Invalido() {
        Long idCurso = 0L;
        String novoNomeProfessor = "Novo Professor";
        when(cursoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(Excecao_ID_Invalido.class, () -> cursoService.alterarProfessor(idCurso, novoNomeProfessor));
    }

    @Test
    public void testExcecaoInativarCursoComID_InvalidID() {
        Long idCurso = 0L;
        when(cursoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(Excecao_ID_Invalido.class, () -> cursoService.inativarPorId(idCurso));
    }
}
