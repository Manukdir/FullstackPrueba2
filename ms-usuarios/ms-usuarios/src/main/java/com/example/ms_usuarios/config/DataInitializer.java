package com.example.ms_usuarios.config;

import com.example.ms_usuarios.model.Perfil;
import com.example.ms_usuarios.model.Usuario;
import com.example.ms_usuarios.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) {
        return args -> {

            if (usuarioRepository.count() == 0) {

                // 1. Creamos un usuario de prueba (tú)
                Usuario usuario1 = new Usuario();
                usuario1.setNombreCompleto("Daniel Chacana");
                usuario1.setEmail("daniel@ecommerce.com");
                usuario1.setPuntosAcumulados(500);
                usuario1.setActivo(true);
                usuario1.setFechaRegistro(LocalDate.now());
                usuario1.setPerfiles(new ArrayList<>());

                // 2. Le creamos un perfil administrador
                Perfil perfil1 = new Perfil();
                perfil1.setNombrePerfil("Administrador");
                perfil1.setDescripcion("Acceso total al sistema E-Commerce");
                perfil1.setNivelPrioridad(1);
                perfil1.setEsPredeterminado(true);
                perfil1.setFechaAsignacion(LocalDate.now());
                perfil1.setUsuario(usuario1); // Relación inversa


                usuario1.getPerfiles().add(perfil1);


                usuarioRepository.save(usuario1);

                System.out.println("CLR ejecutado: Datos iniciales cargados con éxito.");
            } else {
                System.out.println("CLR: La base de datos ya contiene información, se omite la carga inicial.");
            }
        };
    }
}