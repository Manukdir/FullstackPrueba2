package com.example.ms_productos.service;

import com.example.ms_productos.dto.request.ProductoRequestDTO;
import com.example.ms_productos.dto.response.ProductoResponseDTO;
import com.example.ms_productos.mapper.ProductoMapper;
import com.example.ms_productos.model.Producto;
import com.example.ms_productos.repository.CategoriaRepository;
import com.example.ms_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper productoMapper;

    public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {
        Producto p = productoMapper.toEntity(dto);

        categoriaRepository.findById(dto.getCategoriaId()).ifPresent(p::setCategoria);
        return productoMapper.toResponseDTO(productoRepository.save(p));
    }

    public List<ProductoResponseDTO> obtenerTodos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    public List<ProductoResponseDTO> buscarPorNombreYStock(String nombre, Integer stock) {
        return productoRepository.findByNombreContainingAndStockGreaterThan(nombre, stock).stream()
                .map(productoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public boolean eliminar(Long id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}