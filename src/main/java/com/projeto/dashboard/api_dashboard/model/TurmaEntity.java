package com.projeto.dashboard.api_dashboard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "turma")
@Data // Lombok cria getters, setters, equals, hashCode e toString
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // construtor com todos os atributos
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer ano;
    private String periodo;
    private String professor;
}
