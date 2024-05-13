package com.cursosapi.cursos.web.controller;

import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.entity.Curso;
import com.cursosapi.cursos.web.dto.CursoCreateDto;
import com.cursosapi.cursos.web.dto.CursoResponseDto;
import com.cursosapi.cursos.web.dto.mapper.CursoMapper;

import com.cursosapi.cursos.web.exception.MensagemErro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cursos")
public class CursoController {
    private final CursoService cursoService;



    @PostMapping
    @Operation(summary = "Cadastrar um novo curso",
            description = "Este endpoint permite cadastrar um novo curso na base de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso cadastrado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CursoResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class))),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class))),
            @ApiResponse(responseCode = "409", description = "Curso com nome já existente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<CursoResponseDto> cadastrar(
            @Parameter(description = "Dados do curso a ser cadastrado", required = true) @Valid @RequestBody CursoCreateDto dto) {
        Curso curso = cursoService.cadastrar(CursoMapper.toCurso(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));
    }


    @PatchMapping("/{id}/alterar_professor")
    @Operation(summary = "Alterar o professor de um curso", description = "Endpoint para alterar o professor de um curso pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Professor alterado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<CursoResponseDto> alterarProfessor(
            @Parameter(description = "ID do curso a ser alterado", required = true) @PathVariable Long id,
            @Parameter(description = "Novo nome do professor", required = true) @RequestBody String novoNomeProfessor) {
        Curso cursoAtualizado = cursoService.alterarProfessor(id, novoNomeProfessor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{nome}")
    @Operation(summary = "Buscar curso por nome",
            description = "Endpoint para buscar um curso pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CursoResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<CursoResponseDto> buscarCursoPorNome(
            @Parameter(description = "Nome do curso a ser buscado", required = true) @PathVariable String nome) {
        Curso curso = cursoService.buscarPorNome(nome);
        return ResponseEntity.ok(CursoMapper.toDto(curso));
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Buscar curso por ID",
            description = "Endpoint para buscar um curso pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CursoResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<CursoResponseDto> buscarCursoPorId(
            @Parameter(description = "ID do curso a ser buscado", required = true) @PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(CursoMapper.toDto(curso));
    }

    @PatchMapping("/inativar/{id}")
    @Operation(summary = "Inativar curso por ID",
            description = "Endpoint para inativar um curso pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso inativado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CursoResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<CursoResponseDto> inativarCursoPorId(
            @Parameter(description = "ID do curso a ser inativado", required = true) @PathVariable Long id) {
        Curso curso = cursoService.inativarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
