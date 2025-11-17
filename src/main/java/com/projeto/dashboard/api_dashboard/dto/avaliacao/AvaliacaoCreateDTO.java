package com.projeto.dashboard.api_dashboard.dto.avaliacao;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AvaliacaoCreateDTO {

    private LocalDate dataColeta;
    private String coletor;

    private Long alunoId;   // relacionamento com aluno
    private Long moduloId;  // relacionamento com módulo
}
