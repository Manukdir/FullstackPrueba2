package com.example.ms_productos.repository;

import com.example.ms_productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // El profe dijo que usemos nombres de metodos de Spring Data
    List<Producto> findByNombreContainingAndStockGreaterThan(String nombre, Integer stockMinimo);
}