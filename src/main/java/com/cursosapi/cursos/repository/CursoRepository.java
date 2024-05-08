package com.cursosapi.cursos.repository;

import com.cursosapi.cursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    boolean existsByNome(String nome);
}
