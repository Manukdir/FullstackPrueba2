package com.example.ms_usuarios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilResponseDTO {
    private Long id;
    private String nombrePerfil;
    private String descripcion;
    private Integer nivelPrioridad;
    private Boolean esPredeterminado;
    private LocalDate fechaAsignacion;
}