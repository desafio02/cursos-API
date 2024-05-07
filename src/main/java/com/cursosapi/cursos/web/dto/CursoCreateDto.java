package com.cursosapi.cursos.web.dto;

import com.cursosapi.cursos.entity.Curso;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursoCreateDto {

    private String nome;
    private int quantidadeDeHoras;
    private String professor;
    private Curso.AreaConhecimento areaConhecimento;
}
