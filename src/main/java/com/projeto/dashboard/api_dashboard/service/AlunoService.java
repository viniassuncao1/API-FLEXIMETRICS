package com.projeto.dashboard.api_dashboard.service;

import com.projeto.dashboard.api_dashboard.dto.aluno.AlunoCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.aluno.AlunoResponseDTO;
import com.projeto.dashboard.api_dashboard.model.AlunoEntity;
import com.projeto.dashboard.api_dashboard.model.TurmaEntity;
import com.projeto.dashboard.api_dashboard.repository.AlunoRepository;
import com.projeto.dashboard.api_dashboard.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public AlunoService(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public AlunoResponseDTO createAluno(AlunoCreateDTO dto) {

        TurmaEntity turma = turmaRepository.findById(dto.getTurmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        AlunoEntity aluno = new AlunoEntity();
        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setSexo(dto.getSexo());
        aluno.setTurma(turma);

        AlunoEntity saved = alunoRepository.save(aluno);

        return entityToDTO(saved);
    }

    public List<AlunoResponseDTO> getAllAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO getAlunoById(Long id) {
        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return entityToDTO(aluno);
    }

    public AlunoResponseDTO updateAluno(Long id, AlunoCreateDTO dto) {

        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        TurmaEntity turma = turmaRepository.findById(dto.getTurmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setSexo(dto.getSexo());
        aluno.setTurma(turma);

        AlunoEntity updated = alunoRepository.save(aluno);

        return entityToDTO(updated);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    private AlunoResponseDTO entityToDTO(AlunoEntity aluno) {
        AlunoResponseDTO dto = new AlunoResponseDTO();

        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setSexo(aluno.getSexo());

        dto.setTurmaId(aluno.getTurma().getId());
        dto.setNomeTurma(aluno.getTurma().getNome());

        return dto;
    }
}
