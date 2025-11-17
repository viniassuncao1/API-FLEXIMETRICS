package com.projeto.dashboard.api_dashboard.repository;

import com.projeto.dashboard.api_dashboard.model.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByAlunoId(Long alunoId);

    List<AvaliacaoEntity> findByModuloId(Long moduloId);


}
