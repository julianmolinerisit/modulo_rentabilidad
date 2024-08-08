package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carniceria.gestion_rentabilidad.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
