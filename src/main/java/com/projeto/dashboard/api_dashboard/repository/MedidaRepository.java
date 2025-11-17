package com.projeto.dashboard.api_dashboard.repository;

import com.projeto.dashboard.api_dashboard.model.MedidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedidaRepository extends JpaRepository<MedidaEntity, Long> {

    List<MedidaEntity> findByAvaliacaoId(Long avaliacaoId);

    List<MedidaEntity> findByNomeTeste(String nomeTeste);

    List<MedidaEntity> findByAvaliacaoAlunoId(Long alunoId);

    List<MedidaEntity> findByAvaliacaoModuloId(Long moduloId);


}
