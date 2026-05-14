package com.example.ms_productos.service;

import com.example.ms_productos.dto.request.CategoriaRequestDTO;
import com.example.ms_productos.dto.response.CategoriaResponseDTO;
import com.example.ms_productos.mapper.CategoriaMapper;
import com.example.ms_productos.model.Categoria;
import com.example.ms_productos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponseDTO crear(CategoriaRequestDTO dto) {
        Categoria cat = categoriaMapper.toEntity(dto);
        return categoriaMapper.toResponseDTO(categoriaRepository.save(cat));
    }

    public List<CategoriaResponseDTO> obtenerTodas() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // queda igual
    public boolean eliminar(Long id) {
        if(categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}