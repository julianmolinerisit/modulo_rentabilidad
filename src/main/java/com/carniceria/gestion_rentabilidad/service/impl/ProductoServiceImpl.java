package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.repository.ProductoRepository;
import com.carniceria.gestion_rentabilidad.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void updateStock(Long id, int newStock) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setStock(newStock);
        productoRepository.save(producto);
    }
}
