package com.cursosapi.cursos.web;

import com.cursosapi.cursos.service.CursoService;
import com.cursosapi.cursos.entity.Curso;
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
    public Curso cadastrar(@RequestBody Curso curso){
        return cursoService.cadastrar(curso);
    }

    @PatchMapping("/{id}/alterar_professor")
    public ResponseEntity<Curso> alterarProfessor(@PathVariable Long id,
                                                  @RequestBody String novoNomeProfessor) {
        Curso cursoAtualizado = cursoService.alterarProfessor(id, novoNomeProfessor);
        return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
    }
}
