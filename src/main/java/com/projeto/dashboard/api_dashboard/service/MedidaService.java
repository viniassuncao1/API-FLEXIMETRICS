package com.projeto.dashboard.api_dashboard.service;

import com.projeto.dashboard.api_dashboard.dto.medida.MedidaCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.medida.MedidaResponseDTO;
import com.projeto.dashboard.api_dashboard.model.AvaliacaoEntity;
import com.projeto.dashboard.api_dashboard.model.MedidaEntity;
import com.projeto.dashboard.api_dashboard.repository.AvaliacaoRepository;
import com.projeto.dashboard.api_dashboard.repository.MedidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedidaService {

    private final MedidaRepository medidaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public MedidaService(MedidaRepository medidaRepository, AvaliacaoRepository avaliacaoRepository) {
        this.medidaRepository = medidaRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public MedidaResponseDTO createMedida(MedidaCreateDTO dto) {

        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        MedidaEntity medida = new MedidaEntity();
        medida.setNomeTeste(dto.getNomeTeste());
        medida.setValor(dto.getValor());
        medida.setUnidade(dto.getUnidade());
        medida.setAvaliacao(avaliacao);

        MedidaEntity saved = medidaRepository.save(medida);

        return entityToDTO(saved);
    }

    public List<MedidaResponseDTO> getAllMedidas() {
        return medidaRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public List<MedidaResponseDTO> getMedidasByAvaliacao(Long avaliacaoId) {
        return medidaRepository.findAll()
                .stream()
                .filter(m -> m.getAvaliacao().getId().equals(avaliacaoId))
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public void deleteMedida(Long id) {
        medidaRepository.deleteById(id);
    }

    private MedidaResponseDTO entityToDTO(MedidaEntity medida) {
        MedidaResponseDTO dto = new MedidaResponseDTO();

        dto.setId(medida.getId());
        dto.setNomeTeste(medida.getNomeTeste());
        dto.setValor(medida.getValor());
        dto.setUnidade(medida.getUnidade());

        dto.setAvaliacaoId(medida.getAvaliacao().getId());

        dto.setAlunoId(medida.getAvaliacao().getAluno().getId());
        dto.setNomeAluno(medida.getAvaliacao().getAluno().getNome());

        dto.setModuloId(medida.getAvaliacao().getModulo().getId());
        dto.setNomeModulo(medida.getAvaliacao().getModulo().getNome());

        return dto;
    }

    public MedidaResponseDTO createDTOFromEntity(MedidaEntity medida) {
        return entityToDTO(medida);
    }
}
