package com.example.ms_usuarios.controller;

import com.example.ms_usuarios.dto.request.PerfilRequestDTO;
import com.example.ms_usuarios.dto.response.PerfilResponseDTO;
import com.example.ms_usuarios.service.PerfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    public ResponseEntity<PerfilResponseDTO> crear(@Valid @RequestBody PerfilRequestDTO dto) {
        return perfilService.crearPerfil(dto)
                .map(perfil -> new ResponseEntity<>(perfil, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build()); // Retorna 400 si el usuarioId no existe
    }


    @GetMapping
    public ResponseEntity<List<PerfilResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(perfilService.obtenerTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PerfilResponseDTO> obtenerPorId(@PathVariable Long id) {
        return perfilService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<PerfilResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody PerfilRequestDTO dto) {
        return perfilService.actualizarPerfil(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (perfilService.eliminarPerfil(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}