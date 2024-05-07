package com.cursosapi.cursos.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "quantidade_horas")
    private int quantidadeDeHoras;

    private String professor;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_conhecimento")
    private AreaConhecimento areaConhecimento;

    private boolean ativo = true;


    public enum AreaConhecimento {
        PROGRAMACAO,
        DESIGN,
        MATEMATICA,
        CIENCIAS,
        HISTORIA,
        LETRAS;
    }
}