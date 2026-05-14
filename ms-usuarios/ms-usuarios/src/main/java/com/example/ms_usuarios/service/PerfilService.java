package com.example.ms_usuarios.service;

import com.example.ms_usuarios.dto.request.PerfilRequestDTO;
import com.example.ms_usuarios.dto.response.PerfilResponseDTO;
import com.example.ms_usuarios.mapper.PerfilMapper;
import com.example.ms_usuarios.model.Perfil;
import com.example.ms_usuarios.model.Usuario;
import com.example.ms_usuarios.repository.PerfilRepository;
import com.example.ms_usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;
    private final PerfilMapper perfilMapper;


    public Optional<PerfilResponseDTO> crearPerfil(PerfilRequestDTO dto) {

        return usuarioRepository.findById(dto.getUsuarioId()).map(usuario -> {
            Perfil perfil = perfilMapper.toEntity(dto);
            perfil.setUsuario(usuario); // Enlazamos el perfil al usuario
            Perfil guardado = perfilRepository.save(perfil);
            return perfilMapper.toResponseDTO(guardado);
        });
    }


    public List<PerfilResponseDTO> obtenerTodos() {
        return perfilRepository.findAll().stream()
                .map(perfilMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    public Optional<PerfilResponseDTO> obtenerPorId(Long id) {
        return perfilRepository.findById(id)
                .map(perfilMapper::toResponseDTO);
    }


    public Optional<PerfilResponseDTO> actualizarPerfil(Long id, PerfilRequestDTO dto) {
        return perfilRepository.findById(id).map(perfilExistente -> {
            perfilExistente.setNombrePerfil(dto.getNombrePerfil());
            perfilExistente.setDescripcion(dto.getDescripcion());
            perfilExistente.setNivelPrioridad(dto.getNivelPrioridad());
            perfilExistente.setEsPredeterminado(dto.getEsPredeterminado());
            perfilExistente.setFechaAsignacion(dto.getFechaAsignacion());

            Perfil actualizado = perfilRepository.save(perfilExistente);
            return perfilMapper.toResponseDTO(actualizado);
        });
    }


    public boolean eliminarPerfil(Long id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            return true;
        }
        return false;
    }
}