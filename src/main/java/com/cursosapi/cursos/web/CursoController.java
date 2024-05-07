package com.cursosapi.cursos.web;

import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.entity.Curso;
import com.cursosapi.cursos.web.dto.CursoCreateDto;
import com.cursosapi.cursos.web.dto.CursoResponseDto;
import com.cursosapi.cursos.web.dto.mapper.CursoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
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
}
