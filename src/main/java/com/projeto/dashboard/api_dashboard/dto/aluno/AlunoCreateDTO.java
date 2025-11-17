package com.projeto.dashboard.api_dashboard.dto.aluno;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoCreateDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long turmaId; // relacionamento com a Turma
}
