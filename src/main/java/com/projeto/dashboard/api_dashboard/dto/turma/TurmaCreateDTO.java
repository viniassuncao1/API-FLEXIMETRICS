package com.projeto.dashboard.api_dashboard.dto.turma;

import lombok.Data;

@Data
public class TurmaCreateDTO {

    private String nome;
    private Integer ano;
    private String periodo;
    private String professor;
}


