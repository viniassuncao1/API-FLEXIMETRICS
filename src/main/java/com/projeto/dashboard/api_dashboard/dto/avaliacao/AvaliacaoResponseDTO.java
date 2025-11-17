package com.projeto.dashboard.api_dashboard.dto.avaliacao;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AvaliacaoResponseDTO {

    private Long id;
    private LocalDate dataColeta;
    private String coletor;

    private Long alunoId;
    private String nomeAluno;

    private Long moduloId;
    private String nomeModulo;
}
