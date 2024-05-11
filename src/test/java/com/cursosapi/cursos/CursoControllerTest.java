package com.cursosapi.cursos;

import com.cursosapi.cursos.entity.Curso;
import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.web.controller.CursoController;
import com.cursosapi.cursos.web.dto.CursoCreateDto;
import com.cursosapi.cursos.web.dto.CursoResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;




public class CursoControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrar() {
        CursoCreateDto dto = new CursoCreateDto();
        dto.setNome("Curso de Teste");

        Curso cursoMock = new Curso();
        cursoMock.setId(1L);
        cursoMock.setNome("Curso de Teste");

        when(cursoService.cadastrar(any())).thenReturn(cursoMock);

        ResponseEntity<CursoResponseDto> response = cursoController.cadastrar(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cursoMock.getId(), response.getBody().getId());
        assertEquals(cursoMock.getNome(), response.getBody().getNome());

        verify(cursoService, times(1)).cadastrar(any());
    }

    @Test
    public void testInativarCursoPorId() {
        Long id = 1L;
        Curso cursoMock = new Curso();
        cursoMock.setId(id);
        cursoMock.setNome("Curso de Teste");

        when(cursoService.inativarPorId(id)).thenReturn(cursoMock);

        ResponseEntity<CursoResponseDto> response = cursoController.inativarCursoPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cursoMock.getId(), response.getBody().getId());
        assertEquals(cursoMock.getNome(), response.getBody().getNome());

        verify(cursoService, times(1)).inativarPorId(id);
    }

    @Test
    public void testBuscarCursoPorId() {
        Curso cursoSimulado = new Curso();
        cursoSimulado.setId(1L);
        cursoSimulado.setNome("Curso de Teste");
        cursoSimulado.setProfessor("joao da silva");
        cursoSimulado.setAreaConhecimento(Curso.AreaConhecimento.PROGRAMACAO);

        when(cursoService.buscarPorId(1L)).thenReturn(cursoSimulado);

        ResponseEntity<CursoResponseDto> response = cursoController.buscarCursoPorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(cursoSimulado.getId(), response.getBody().getId());
        assertEquals(cursoSimulado.getNome(), response.getBody().getNome());
        assertEquals(cursoSimulado.getProfessor(), response.getBody().getProfessor());
        assertEquals(cursoSimulado.getAreaConhecimento(), response.getBody().getAreaConhecimento());
    }

    @Test
    public void testBuscarCursoPorNome() {
        Curso cursoSimulado = new Curso();
        cursoSimulado.setId(1L);
        cursoSimulado.setNome("Curso de Teste");
        cursoSimulado.setProfessor("joao da silva");
        cursoSimulado.setAreaConhecimento(Curso.AreaConhecimento.PROGRAMACAO);

        when(cursoService.buscarPorNome("Curso de Teste")).thenReturn(cursoSimulado);

        ResponseEntity<CursoResponseDto> response = cursoController.buscarCursoPorNome("Curso de Teste");

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(cursoSimulado.getId(), response.getBody().getId());
        assertEquals(cursoSimulado.getNome(), response.getBody().getNome());
        assertEquals(cursoSimulado.getProfessor(), response.getBody().getProfessor());
        assertEquals(cursoSimulado.getAreaConhecimento(), response.getBody().getAreaConhecimento());
    }


    @Test
    public void TestAlterarProfessor() {
        Curso cursoSimulado = new Curso();
        cursoSimulado.setId(1L);
        cursoSimulado.setNome("Curso de Teste");
        cursoSimulado.setProfessor("Professor de teste");
        cursoSimulado.setAreaConhecimento(Curso.AreaConhecimento.PROGRAMACAO);

        String novoNome = "Professor de teste";
        when(cursoService.alterarProfessor(1L, novoNome)).thenReturn(cursoSimulado);

        ResponseEntity<CursoResponseDto> response = cursoController.alterarProfessor(1L, novoNome);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(cursoSimulado.getProfessor(), response.getBody().getProfessor());
    }



}

