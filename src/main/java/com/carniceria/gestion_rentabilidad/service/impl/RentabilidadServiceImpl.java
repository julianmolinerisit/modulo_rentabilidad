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
        return productoRepository.findAll(); // Ajustar para calcular la rentabilidad
    }
    
    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
