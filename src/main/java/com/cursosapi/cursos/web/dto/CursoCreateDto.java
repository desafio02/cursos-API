package com.cursosapi.cursos.web.dto;

import com.cursosapi.cursos.entity.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursoCreateDto {

    @NotBlank
    private String nome;

    @Positive(message = "O numero de horas deve ser maior que zero")
    private int quantidadeDeHoras;

    @NotBlank
    private String professor;

    private Curso.AreaConhecimento areaConhecimento;
}
