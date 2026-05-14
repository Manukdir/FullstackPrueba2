package com.example.ms_usuarios.dto.request;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequestDTO {
    @NotBlank(message = "El nombre completo no puede estar vacío")
    private String nombreCompleto;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un formato de email válido")
    private String email;

    @NotNull(message = "Los puntos son obligatorios")
    @Min(value = 0, message = "Los puntos no pueden ser negativos")
    private Integer puntosAcumulados;

    @NotNull(message = "El estado activo es obligatorio")
    private Boolean activo;

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;
}
