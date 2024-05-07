package com.cursosapi.cursos.web.dto;

import com.cursosapi.cursos.entity.Curso;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CursoResponseDto {

    private Long id;

    private String nome;

    private int quantidadeDeHoras;

    private String professor;

    private Curso.AreaConhecimento areaConhecimento;

    private boolean ativo;
}
