package com.projeto.dashboard.api_dashboard.dto.medida;

import lombok.Data;

@Data
public class MedidaCreateDTO {

    private String nomeTeste;
    private Double valor;
    private String unidade;

    private Long avaliacaoId; // vínculo com a avaliação
}
