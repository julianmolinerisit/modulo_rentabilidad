package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}