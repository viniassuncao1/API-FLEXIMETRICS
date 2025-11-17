package com.projeto.dashboard.api_dashboard.service;

import com.projeto.dashboard.api_dashboard.dto.avaliacao.AvaliacaoCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.avaliacao.AvaliacaoResponseDTO;
import com.projeto.dashboard.api_dashboard.model.AlunoEntity;
import com.projeto.dashboard.api_dashboard.model.AvaliacaoEntity;
import com.projeto.dashboard.api_dashboard.model.ModuloEntity;
import com.projeto.dashboard.api_dashboard.repository.AlunoRepository;
import com.projeto.dashboard.api_dashboard.repository.AvaliacaoRepository;
import com.projeto.dashboard.api_dashboard.repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AlunoRepository alunoRepository;
    private final ModuloRepository moduloRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository,
                            AlunoRepository alunoRepository,
                            ModuloRepository moduloRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.alunoRepository = alunoRepository;
        this.moduloRepository = moduloRepository;
    }

    public AvaliacaoResponseDTO createAvaliacao(AvaliacaoCreateDTO dto) {

        AlunoEntity aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        ModuloEntity modulo = moduloRepository.findById(dto.getModuloId())
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));

        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setDataColeta(dto.getDataColeta());
        avaliacao.setColetor(dto.getColetor());
        avaliacao.setAluno(aluno);
        avaliacao.setModulo(modulo);

        AvaliacaoEntity saved = avaliacaoRepository.save(avaliacao);

        return entityToDTO(saved);
    }

    public List<AvaliacaoResponseDTO> getAllAvaliacoes() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public AvaliacaoResponseDTO getAvaliacaoById(Long id) {
        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        return entityToDTO(avaliacao);
    }

    public AvaliacaoResponseDTO updateAvaliacao(Long id, AvaliacaoCreateDTO dto) {

        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        AlunoEntity aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        ModuloEntity modulo = moduloRepository.findById(dto.getModuloId())
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));

        avaliacao.setDataColeta(dto.getDataColeta());
        avaliacao.setColetor(dto.getColetor());
        avaliacao.setAluno(aluno);
        avaliacao.setModulo(modulo);

        AvaliacaoEntity updated = avaliacaoRepository.save(avaliacao);

        return entityToDTO(updated);
    }

    public void deleteAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }

    private AvaliacaoResponseDTO entityToDTO(AvaliacaoEntity avaliacao) {
        AvaliacaoResponseDTO dto = new AvaliacaoResponseDTO();

        dto.setId(avaliacao.getId());
        dto.setDataColeta(avaliacao.getDataColeta());
        dto.setColetor(avaliacao.getColetor());

        dto.setAlunoId(avaliacao.getAluno().getId());
        dto.setNomeAluno(avaliacao.getAluno().getNome());

        dto.setModuloId(avaliacao.getModulo().getId());
        dto.setNomeModulo(avaliacao.getModulo().getNome());

        return dto;
    }
}
