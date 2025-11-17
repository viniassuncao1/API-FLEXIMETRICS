package com.projeto.dashboard.api_dashboard.service;

import com.projeto.dashboard.api_dashboard.dto.modulo.ModuloCreateDTO;
import com.projeto.dashboard.api_dashboard.dto.modulo.ModuloResponseDTO;
import com.projeto.dashboard.api_dashboard.model.ModuloEntity;
import com.projeto.dashboard.api_dashboard.repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloService {

    private final ModuloRepository moduloRepository;

    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    public ModuloResponseDTO createModulo(ModuloCreateDTO dto) {
        ModuloEntity modulo = new ModuloEntity();
        modulo.setNome(dto.getNome());
        modulo.setDescricao(dto.getDescricao());

        ModuloEntity saved = moduloRepository.save(modulo);
        return entityToDTO(saved);
    }

    public List<ModuloResponseDTO> getAllModulos() {
        return moduloRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public ModuloResponseDTO getModuloById(Long id) {
        ModuloEntity modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));

        return entityToDTO(modulo);
    }

    public ModuloResponseDTO updateModulo(Long id, ModuloCreateDTO dto) {
        ModuloEntity modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo não encontrado"));

        modulo.setNome(dto.getNome());
        modulo.setDescricao(dto.getDescricao());

        ModuloEntity updated = moduloRepository.save(modulo);
        return entityToDTO(updated);
    }

    public void deleteModulo(Long id) {
        moduloRepository.deleteById(id);
    }

    private ModuloResponseDTO entityToDTO(ModuloEntity modulo) {
        ModuloResponseDTO dto = new ModuloResponseDTO();

        dto.setId(modulo.getId());
        dto.setNome(modulo.getNome());
        dto.setDescricao(modulo.getDescricao());

        return dto;
    }
}
