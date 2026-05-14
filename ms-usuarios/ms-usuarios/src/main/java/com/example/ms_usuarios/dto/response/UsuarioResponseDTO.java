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
public class UsuarioResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    private Integer puntosAcumulados;
    private Boolean activo;
    private LocalDate fechaRegistro;
}