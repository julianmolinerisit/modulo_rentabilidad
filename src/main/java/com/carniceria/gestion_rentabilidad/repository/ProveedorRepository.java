package com.carniceria.gestion_rentabilidad.repository;

import com.carniceria.gestion_rentabilidad.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
