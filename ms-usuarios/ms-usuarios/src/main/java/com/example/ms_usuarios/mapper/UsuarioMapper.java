package com.example.ms_usuarios.mapper;

import com.example.ms_usuarios.dto.request.UsuarioRequestDTO;
import com.example.ms_usuarios.dto.response.UsuarioResponseDTO;
import com.example.ms_usuarios.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    public Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setEmail(dto.getEmail());
        usuario.setPuntosAcumulados(dto.getPuntosAcumulados());
        usuario.setActivo(dto.getActivo());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        return usuario;
    }


    public UsuarioResponseDTO toResponseDTO(Usuario entity) {
        if (entity == null) return null;

        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(entity.getId());
        dto.setNombreCompleto(entity.getNombreCompleto());
        dto.setEmail(entity.getEmail());
        dto.setPuntosAcumulados(entity.getPuntosAcumulados());
        dto.setActivo(entity.getActivo());
        dto.setFechaRegistro(entity.getFechaRegistro());
        return dto;
    }
}