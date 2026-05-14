package com.example.ms_productos.config;

import com.example.ms_productos.model.Categoria;
import com.example.ms_productos.model.Producto;
import com.example.ms_productos.repository.CategoriaRepository;
import com.example.ms_productos.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository productoRepository,
                                   CategoriaRepository categoriaRepository) {
        return args -> {

            if (categoriaRepository.count() == 0) {


                Categoria cat1 = new Categoria();
                cat1.setNombre("Electronica");
                cat1.setDescripcion("Todo lo que usa cables o pilas");
                categoriaRepository.save(cat1);


                Producto p1 = new Producto();
                p1.setNombre("Teclado Mecanico Gamer");
                p1.setCodigoSku("SKU-1001");
                p1.setPrecio(45000.0);
                p1.setStock(15);
                p1.setFechaIngreso(LocalDate.now());
                p1.setCategoria(cat1); // Aqui

                Producto p2 = new Producto();
                p2.setNombre("Mouse Inalambrico Pro");
                p2.setCodigoSku("SKU-1002");
                p2.setPrecio(25000.0);
                p2.setStock(5);
                p2.setFechaIngreso(LocalDate.now());
                p2.setCategoria(cat1);

                productoRepository.save(p1);
                productoRepository.save(p2);

                System.out.println(" MS-PRODUCTOS: Datos de prueba cargados con exito.");
            } else {
                System.out.println("MS-PRODUCTOS: Ya existen datos - saltando carga inicial.");
            }
        };
    }
}