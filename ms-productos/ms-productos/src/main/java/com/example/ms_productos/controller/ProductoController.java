package com.example.ms_productos.controller;

import com.example.ms_productos.dto.request.ProductoRequestDTO;
import com.example.ms_productos.dto.response.ProductoResponseDTO;
import com.example.ms_productos.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(201).body(productoService.crearProducto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<ProductoResponseDTO>> filtrar(
            @RequestParam String nombre,
            @RequestParam Integer stock) {
        return ResponseEntity.ok(productoService.buscarPorNombreYStock(nombre, stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if(productoService.eliminar(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}