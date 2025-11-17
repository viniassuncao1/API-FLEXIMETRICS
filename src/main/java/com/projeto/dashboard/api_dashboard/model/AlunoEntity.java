package com.projeto.dashboard.api_dashboard.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String sexo; // "M" ou "F"

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaEntity turma;
}
