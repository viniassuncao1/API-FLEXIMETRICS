package com.projeto.dashboard.api_dashboard.controller;

import com.projeto.dashboard.api_dashboard.dto.avaliacao.AvaliacaoCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.avaliacao.AvaliacaoResponseDTO;
import com.projeto.dashboard.api_dashboard.service.AvaliacaoService;
import com.projeto.dashboard.api_dashboard.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoService avaliacaoService,
                               AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoService = avaliacaoService;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @PostMapping
    public AvaliacaoResponseDTO createAvaliacao(@RequestBody AvaliacaoCreateDTO dto) {
        return avaliacaoService.createAvaliacao(dto);
    }

    @GetMapping
    public List<AvaliacaoResponseDTO> getAllAvaliacoes() {
        return avaliacaoService.getAllAvaliacoes();
    }

    @GetMapping("/{id}")
    public AvaliacaoResponseDTO getAvaliacaoById(@PathVariable Long id) {
        return avaliacaoService.getAvaliacaoById(id);
    }

    @PutMapping("/{id}")
    public AvaliacaoResponseDTO updateAvaliacao(@PathVariable Long id,
                                                @RequestBody AvaliacaoCreateDTO dto) {
        return avaliacaoService.updateAvaliacao(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAvaliacao(@PathVariable Long id) {
        avaliacaoService.deleteAvaliacao(id);
    }

    // 🔵 Buscar avaliações por aluno
    @GetMapping("/aluno/{alunoId}")
    public List<AvaliacaoResponseDTO> getAvaliacoesByAluno(@PathVariable Long alunoId) {
        return avaliacaoRepository.findByAlunoId(alunoId)
                .stream()
                .map(a -> avaliacaoService.getAvaliacaoById(a.getId())) // reaproveita DTO
                .toList();
    }

    // 🟣 Buscar avaliações por módulo
    @GetMapping("/modulo/{moduloId}")
    public List<AvaliacaoResponseDTO> getAvaliacoesByModulo(@PathVariable Long moduloId) {
        return avaliacaoRepository.findByModuloId(moduloId)
                .stream()
                .map(a -> avaliacaoService.getAvaliacaoById(a.getId()))
                .toList();
    }
}
