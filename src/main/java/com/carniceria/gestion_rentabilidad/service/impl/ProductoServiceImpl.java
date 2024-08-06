package com.carniceria.gestion_rentabilidad.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Producto getProductoById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void updateStock(Long id, int newStock) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setStock(newStock);
            saveProducto(producto);
        }
    }

    @Override
    public void updatePrecioVenta(Long id, double nuevoPrecioVenta) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setPrecioVenta(nuevoPrecioVenta);
            producto.actualizarInversionTotal();
            saveProducto(producto);
        }
    }

    @Override
    public void updateRentabilidad(Long id, double nuevaRentabilidad) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setPorcentajeRentabilidad(nuevaRentabilidad);
            producto.actualizarInversionTotal();
            saveProducto(producto);
        }
    }

    @Override
    public void updateGrasaDesperdicio(Long id, double nuevaGrasaDesperdicio) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setGrasaDesperdicio(nuevaGrasaDesperdicio);
            producto.setFechaRegistro(LocalDate.now());
            saveProducto(producto);
        }
    }

    @Override
    public void updateOtrosDesperdicios(Long id, double nuevosOtrosDesperdicios) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setOtrosDesperdicios(nuevosOtrosDesperdicios);
            producto.setFechaRegistro(LocalDate.now());
            saveProducto(producto);
        }
    }

    @Override
    public void updateDesperdicio(Long id, Double grasaDesperdicio, Double otrosDesperdicios) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setGrasaDesperdicio(grasaDesperdicio);
            producto.setOtrosDesperdicios(otrosDesperdicios);
            producto.setFechaRegistro(LocalDate.now());
            saveProducto(producto);
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
