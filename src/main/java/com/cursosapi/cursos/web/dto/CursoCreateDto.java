package com.cursosapi.cursos.web.dto;

import com.cursosapi.cursos.entity.Curso;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursoCreateDto {

    @NotBlank
    private String nome;

    @NotBlank
    private int quantidadeDeHoras;

    @NotBlank
    private String professor;

    private Curso.AreaConhecimento areaConhecimento;
}
