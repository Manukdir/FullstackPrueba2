package com.example.ms_productos.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String codigoSku;
    private Double precio;
    private Integer stock;
    private LocalDate fechaIngreso;
    private String nombreCategoria;
}