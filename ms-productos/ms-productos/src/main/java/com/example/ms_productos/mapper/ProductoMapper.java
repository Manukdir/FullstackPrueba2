package com.example.ms_productos.mapper;

import com.example.ms_productos.dto.request.ProductoRequestDTO;
import com.example.ms_productos.dto.response.ProductoResponseDTO;
import com.example.ms_productos.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setCodigoSku(dto.getCodigoSku());
        p.setPrecio(dto.getPrecio());
        p.setStock(dto.getStock());
        p.setFechaIngreso(dto.getFechaIngreso());
        return p;
    }

    public ProductoResponseDTO toResponseDTO(Producto p) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setCodigoSku(p.getCodigoSku());
        dto.setPrecio(p.getPrecio());
        dto.setStock(p.getStock());
        dto.setFechaIngreso(p.getFechaIngreso());
        if(p.getCategoria() != null) {
            dto.setNombreCategoria(p.getCategoria().getNombre());
        }
        return dto;
    }
}