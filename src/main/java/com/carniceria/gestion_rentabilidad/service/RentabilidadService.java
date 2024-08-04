package com.carniceria.gestion_rentabilidad.service;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentabilidadService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductosConRentabilidad() {
        // Lógica para obtener productos con datos de rentabilidad
        return productoRepository.findAll(); // Ejemplo, puede variar
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
