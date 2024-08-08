package com.carniceria.gestion_rentabilidad.service.impl;

import com.carniceria.gestion_rentabilidad.model.Proveedor;
import com.carniceria.gestion_rentabilidad.repository.ProveedorRepository;
import com.carniceria.gestion_rentabilidad.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public void saveProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProveedorById(Long id) {
        proveedorRepository.deleteById(id);
    }
}
