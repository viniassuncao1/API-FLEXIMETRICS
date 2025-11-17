package com.projeto.dashboard.api_dashboard.repository;

import com.projeto.dashboard.api_dashboard.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
