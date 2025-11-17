package com.projeto.dashboard.api_dashboard.controller;

import com.projeto.dashboard.api_dashboard.dto.aluno.AlunoCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.aluno.AlunoResponseDTO;
import com.projeto.dashboard.api_dashboard.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponseDTO createAluno(@RequestBody AlunoCreateDTO dto) {
        return alunoService.createAluno(dto);
    }

    @GetMapping
    public List<AlunoResponseDTO> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO updateAluno(@PathVariable Long id, @RequestBody AlunoCreateDTO dto) {
        return alunoService.updateAluno(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
}
