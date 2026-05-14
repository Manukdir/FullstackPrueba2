package com.example.ms_usuarios.controller;

import com.example.ms_usuarios.dto.request.UsuarioRequestDTO;
import com.example.ms_usuarios.dto.response.UsuarioResponseDTO;
import com.example.ms_usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO creado = usuarioService.crearUsuario(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.actualizarUsuario(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (usuarioService.eliminarUsuario(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    // Ruta en Postman: GET /api/usuarios/buscar?email=ejemplo@correo.com&activo=true
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioResponseDTO> buscarPorEmailYActivo(
            @RequestParam String email,
            @RequestParam Boolean activo) {
        return usuarioService.buscarPorEmailYActivo(email, activo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}