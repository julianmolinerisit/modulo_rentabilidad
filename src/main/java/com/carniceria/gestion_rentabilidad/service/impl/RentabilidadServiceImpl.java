package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.repository.ProductoRepository;
import com.carniceria.gestion_rentabilidad.service.RentabilidadService;

@Service
public class RentabilidadServiceImpl implements RentabilidadService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductosConRentabilidad() {
        // Puede ajustar esta parte si es necesario calcular la rentabilidad en base a los productos existentes
        return productoRepository.findAll();
    }
    
    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        if (producto != null) {
            productoRepository.save(producto);
        }
    }
}
