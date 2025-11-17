package com.projeto.dashboard.api_dashboard.controller;

import com.projeto.dashboard.api_dashboard.dto.medida.MedidaCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.medida.MedidaResponseDTO;
import com.projeto.dashboard.api_dashboard.service.MedidaService;
import com.projeto.dashboard.api_dashboard.repository.MedidaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medidas")
public class MedidaController {

    private final MedidaService medidaService;
    private final MedidaRepository medidaRepository;

    public MedidaController(MedidaService medidaService, MedidaRepository medidaRepository) {
        this.medidaService = medidaService;
        this.medidaRepository = medidaRepository;
    }

    @PostMapping
    public MedidaResponseDTO createMedida(@RequestBody MedidaCreateDTO dto) {
        return medidaService.createMedida(dto);
    }
    @GetMapping
    public List<MedidaResponseDTO> getAllMedidas() {
        return medidaService.getAllMedidas();
    }

    @GetMapping("/avaliacao/{avaliacaoId}")
    public List<MedidaResponseDTO> getMedidasByAvaliacao(@PathVariable Long avaliacaoId) {
        return medidaService.getMedidasByAvaliacao(avaliacaoId);
    }

    // Buscar medidas por nome do teste (ex.: "IMC", "Flexibilidade")
    @GetMapping("/teste/{nomeTeste}")
    public List<MedidaResponseDTO> getByNomeTeste(@PathVariable String nomeTeste) {
        return medidaRepository.findByNomeTeste(nomeTeste)
                .stream()
                .map(medidaService::createDTOFromEntity) // vamos criar esse método auxiliar
                .toList();
    }

    // Buscar medidas por aluno
    @GetMapping("/aluno/{alunoId}")
    public List<MedidaResponseDTO> getMedidasByAluno(@PathVariable Long alunoId) {
        return medidaRepository.findByAvaliacaoAlunoId(alunoId)
                .stream()
                .map(medidaService::createDTOFromEntity)
                .toList();
    }

    // Buscar medidas por módulo
    @GetMapping("/modulo/{moduloId}")
    public List<MedidaResponseDTO> getMedidasByModulo(@PathVariable Long moduloId) {
        return medidaRepository.findByAvaliacaoModuloId(moduloId)
                .stream()
                .map(medidaService::createDTOFromEntity)
                .toList();
    }

    // Deletar medida
    @DeleteMapping("/{id}")
    public void deleteMedida(@PathVariable Long id) {
        medidaService.deleteMedida(id);
    }
}
