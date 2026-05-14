package com.example.ms_productos.mapper;

import com.example.ms_productos.dto.request.CategoriaRequestDTO;
import com.example.ms_productos.dto.response.CategoriaResponseDTO;
import com.example.ms_productos.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDTO dto) {
        Categoria c = new Categoria();
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        return c;
    }

    public CategoriaResponseDTO toResponseDTO(Categoria c) {
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setDescripcion(c.getDescripcion());
        return dto;
    }
}