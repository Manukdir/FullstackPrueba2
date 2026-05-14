package com.example.ms_usuarios.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PerfilRequestDTO {

    @NotBlank(message = "El nombre del perfil es obligatorio")
    private String nombrePerfil;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El nivel de prioridad es obligatorio")
    @Min(value = 1, message = "El nivel mínimo de prioridad es 1")
    private Integer nivelPrioridad;

    @NotNull(message = "Debe indicar si es el predeterminado")
    private Boolean esPredeterminado;

    @NotNull(message = "La fecha de asignación es obligatoria")
    private LocalDate fechaAsignacion;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;
}