package com.projeto.dashboard.api_dashboard.controller;

import com.projeto.dashboard.api_dashboard.dto.modulo.ModuloCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.modulo.ModuloResponseDTO;
import com.projeto.dashboard.api_dashboard.service.ModuloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @PostMapping
    public ModuloResponseDTO createModulo(@RequestBody ModuloCreateDTO dto) {
        return moduloService.createModulo(dto);
    }

    @GetMapping
    public List<ModuloResponseDTO> getAllModulos() {
        return moduloService.getAllModulos();
    }

    @GetMapping("/{id}")
    public ModuloResponseDTO getModuloById(@PathVariable Long id) {
        return moduloService.getModuloById(id);
    }

    @PutMapping("/{id}")
    public ModuloResponseDTO updateModulo(@PathVariable Long id, @RequestBody ModuloCreateDTO dto) {
        return moduloService.updateModulo(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteModulo(@PathVariable Long id) {
        moduloService.deleteModulo(id);
    }
}
