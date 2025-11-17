package com.projeto.dashboard.api_dashboard.controller;

import com.projeto.dashboard.api_dashboard.dto.turma.TurmaCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.turma.TurmaResponseDTO;
import com.projeto.dashboard.api_dashboard.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaResponseDTO createTurma(@RequestBody TurmaCreateDTO dto) {
        return turmaService.createTurma(dto);
    }

    @GetMapping
    public List<TurmaResponseDTO> getAllTurmas() {
        return turmaService.getAllTurmas();
    }

    @GetMapping("/{id}")
    public TurmaResponseDTO getTurmaById(@PathVariable Long id) {
        return turmaService.getTurmaById(id);
    }

    @PutMapping("/{id}")
    public TurmaResponseDTO updateTurma(@PathVariable Long id, @RequestBody TurmaCreateDTO dto) {
        return turmaService.updateTurma(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
    }
}
