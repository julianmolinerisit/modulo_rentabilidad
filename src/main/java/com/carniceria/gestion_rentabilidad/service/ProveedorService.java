package com.carniceria.gestion_rentabilidad.service;

import com.carniceria.gestion_rentabilidad.model.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    void saveProveedor(Proveedor proveedor);
    Proveedor getProveedorById(Long id);
    void deleteProveedorById(Long id);
}
