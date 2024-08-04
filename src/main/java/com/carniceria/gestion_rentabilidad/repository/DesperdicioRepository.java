package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carniceria.gestion_rentabilidad.model.Desperdicio;

public interface DesperdicioRepository extends JpaRepository<Desperdicio, Long> {
}
