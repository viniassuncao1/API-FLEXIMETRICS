package com.projeto.dashboard.api_dashboard.dto.turma;

import lombok.Data;

@Data
public class TurmaResponseDTO {

    private Long id;
    private String nome;
    private Integer ano;
    private String periodo;
    private String professor;
}
