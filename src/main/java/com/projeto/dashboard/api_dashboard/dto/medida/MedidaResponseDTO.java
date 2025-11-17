package com.projeto.dashboard.api_dashboard.dto.medida;

import lombok.Data;

@Data
public class MedidaResponseDTO {

    private Long id;
    private String nomeTeste;
    private Double valor;
    private String unidade;

    private Long avaliacaoId;

    private Long alunoId;
    private String nomeAluno;

    private Long moduloId;
    private String nomeModulo;
}
