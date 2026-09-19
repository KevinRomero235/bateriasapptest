package com.bateriasapp.repository;

import com.bateriasapp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto id(Long id);
}