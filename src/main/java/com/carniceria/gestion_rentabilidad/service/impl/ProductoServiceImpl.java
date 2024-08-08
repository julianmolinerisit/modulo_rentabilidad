package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveProducto(Producto producto) {
        producto.actualizarInversionTotal();
        productoRepository.save(producto);
    }




    @Override
    @Transactional
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarProducto(Producto producto) {
        producto.actualizarInversionTotal();
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteProductoById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return getAllProductos();
    }
}
