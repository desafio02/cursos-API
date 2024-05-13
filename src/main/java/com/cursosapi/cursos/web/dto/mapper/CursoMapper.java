package com.cursosapi.cursos.web.dto.mapper;

import com.cursosapi.cursos.entity.Curso;
import com.cursosapi.cursos.web.dto.CursoCreateDto;
import com.cursosapi.cursos.web.dto.CursoResponseDto;
import org.modelmapper.ModelMapper;

public class CursoMapper {

    public static Curso toCurso(CursoCreateDto dto) {
        return new ModelMapper().map(dto, Curso.class);
    }

    public static CursoResponseDto toDto(Curso curso) {
        return new ModelMapper().map(curso, CursoResponseDto.class);
    }
}
