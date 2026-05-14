package com.example.ms_productos.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequestDTO {
    @NotBlank(message = "el nombre de la categoria no puede estar vacio")
    private String nombre;
    private String descripcion;
}