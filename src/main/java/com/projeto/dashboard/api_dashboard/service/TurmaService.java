package com.projeto.dashboard.api_dashboard.service;

import com.projeto.dashboard.api_dashboard.dto.turma.TurmaCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.turma.TurmaResponseDTO;
import com.projeto.dashboard.api_dashboard.model.TurmaEntity;
import com.projeto.dashboard.api_dashboard.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaResponseDTO createTurma(TurmaCreateDTO dto) {
        TurmaEntity turma = new TurmaEntity();
        turma.setNome(dto.getNome());
        turma.setAno(dto.getAno());
        turma.setPeriodo(dto.getPeriodo());
        turma.setProfessor(dto.getProfessor());

        TurmaEntity saved = turmaRepository.save(turma);

        return entityToDTO(saved);
    }

    public List<TurmaResponseDTO> getAllTurmas() {
        return turmaRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public TurmaResponseDTO getTurmaById(Long id) {
        TurmaEntity turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        return entityToDTO(turma);
    }

    public TurmaResponseDTO updateTurma(Long id, TurmaCreateDTO dto) {
        TurmaEntity turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        turma.setNome(dto.getNome());
        turma.setAno(dto.getAno());
        turma.setPeriodo(dto.getPeriodo());
        turma.setProfessor(dto.getProfessor());

        TurmaEntity updated = turmaRepository.save(turma);
        return entityToDTO(updated);
    }

    public void deleteTurma(Long id) {
        turmaRepository.deleteById(id);
    }

    private TurmaResponseDTO entityToDTO(TurmaEntity turma) {
        TurmaResponseDTO dto = new TurmaResponseDTO();

        dto.setId(turma.getId());
        dto.setNome(turma.getNome());
        dto.setAno(turma.getAno());
        dto.setPeriodo(turma.getPeriodo());
        dto.setProfessor(turma.getProfessor());

        return dto;
    }
}
