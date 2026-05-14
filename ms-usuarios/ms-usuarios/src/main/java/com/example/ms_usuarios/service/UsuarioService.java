package com.example.ms_usuarios.service;

import com.example.ms_usuarios.dto.request.UsuarioRequestDTO;
import com.example.ms_usuarios.dto.response.UsuarioResponseDTO;
import com.example.ms_usuarios.mapper.UsuarioMapper;
import com.example.ms_usuarios.model.Usuario;
import com.example.ms_usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(guardado);
    }

    public List<UsuarioResponseDTO> obtenerTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toResponseDTO);
    }

    public Optional<UsuarioResponseDTO> actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNombreCompleto(dto.getNombreCompleto());
            usuarioExistente.setEmail(dto.getEmail());
            usuarioExistente.setPuntosAcumulados(dto.getPuntosAcumulados());
            usuarioExistente.setActivo(dto.getActivo());
            usuarioExistente.setFechaRegistro(dto.getFechaRegistro());

            Usuario actualizado = usuarioRepository.save(usuarioExistente);
            return usuarioMapper.toResponseDTO(actualizado);
        });
    }


    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Optional<UsuarioResponseDTO> buscarPorEmailYActivo(String email, Boolean activo) {
        return usuarioRepository.findByEmailAndActivo(email, activo)
                .map(usuarioMapper::toResponseDTO);
    }
}