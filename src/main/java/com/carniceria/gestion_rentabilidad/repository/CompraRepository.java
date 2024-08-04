package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.model.Producto;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}