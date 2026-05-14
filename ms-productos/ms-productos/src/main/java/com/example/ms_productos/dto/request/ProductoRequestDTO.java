package com.example.ms_productos.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ProductoRequestDTO {
    @NotBlank(message = "ponele nombre al producto")
    private String nombre;

    @NotBlank(message = "el sku es obligatorio")
    private String codigoSku;

    @Positive(message = "el precio tiene que ser mayor a 0")
    private Double precio;

    @Min(value = 0, message = "no podes tener stock negativo")
    private Integer stock;

    private LocalDate fechaIngreso;

    @NotNull(message = "tienes que decir a que categoria pertenece")
    private Long categoriaId;
}