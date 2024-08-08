package com.carniceria.gestion_rentabilidad.repository;

import com.carniceria.gestion_rentabilidad.model.PagosProveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PagosProveedoresRepository extends JpaRepository<PagosProveedores, Long> {
    List<PagosProveedores> findByProveedorId(Long proveedorId);
}
