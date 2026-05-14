package com.example.ms_usuarios.mapper;

import com.example.ms_usuarios.dto.request.PerfilRequestDTO;
import com.example.ms_usuarios.dto.response.PerfilResponseDTO;
import com.example.ms_usuarios.model.Perfil;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public Perfil toEntity(PerfilRequestDTO dto) {
        if (dto == null) return null;

        Perfil perfil = new Perfil();
        perfil.setNombrePerfil(dto.getNombrePerfil());
        perfil.setDescripcion(dto.getDescripcion());
        perfil.setNivelPrioridad(dto.getNivelPrioridad());
        perfil.setEsPredeterminado(dto.getEsPredeterminado());
        perfil.setFechaAsignacion(dto.getFechaAsignacion());
        return perfil;
    }

    public PerfilResponseDTO toResponseDTO(Perfil entity) {
        if (entity == null) return null;

        PerfilResponseDTO dto = new PerfilResponseDTO();
        dto.setId(entity.getId());
        dto.setNombrePerfil(entity.getNombrePerfil());
        dto.setDescripcion(entity.getDescripcion());
        dto.setNivelPrioridad(entity.getNivelPrioridad());
        dto.setEsPredeterminado(entity.getEsPredeterminado());
        dto.setFechaAsignacion(entity.getFechaAsignacion());
        return dto;
    }
}