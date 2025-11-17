package com.projeto.dashboard.api_dashboard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTeste;

    private Double valor;

    private String unidade;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id")
    private AvaliacaoEntity avaliacao;
}
