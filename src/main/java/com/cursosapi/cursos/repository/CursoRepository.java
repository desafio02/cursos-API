package com.cursosapi.cursos.repository;

import com.cursosapi.cursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    boolean existsByNome(String nome);

    Optional<Curso> findByNome(String nome);
}
