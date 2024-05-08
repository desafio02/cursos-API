package com.cursosapi.cursos.web.controller;

import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.entity.Curso;
import com.cursosapi.cursos.web.dto.CursoCreateDto;
import com.cursosapi.cursos.web.dto.CursoResponseDto;
import com.cursosapi.cursos.web.dto.mapper.CursoMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<CursoResponseDto> cadastrar(@RequestBody CursoCreateDto dto){
        Curso curso = cursoService.cadastrar(CursoMapper.toCurso(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));
    }

    @PatchMapping("/{id}/alterar_professor")
    public ResponseEntity<CursoResponseDto> alterarProfessor(@PathVariable Long id,
                                                  @RequestBody String novoNomeProfessor) {
        Curso cursoAtualizado = cursoService.alterarProfessor(id, novoNomeProfessor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CursoMapper.toDto(cursoAtualizado));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> getTodosOsCursos() {
        List<Curso> cursos = cursoService.buscarTodos();
        List<CursoResponseDto> cursosDto = new ArrayList<>();
        for (Curso c : cursos) {
            cursosDto.add(CursoMapper.toDto(c));
        }
        return ResponseEntity.ok(cursosDto);
    }
}
