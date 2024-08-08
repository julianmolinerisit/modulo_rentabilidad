package com.carniceria.gestion_rentabilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carniceria.gestion_rentabilidad.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import com.carniceria.gestion_rentabilidad.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
