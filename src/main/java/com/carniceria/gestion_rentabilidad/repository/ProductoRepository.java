package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.gestion_rentabilidad.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
