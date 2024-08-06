package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Producto;

public interface ProductoService {

    List<Producto> getAllProductos();

    Producto getProductoById(Long id);

    void saveProducto(Producto producto);

    void updateStock(Long id, int newStock);

    void updatePrecioVenta(Long id, double nuevoPrecioVenta);

    void updateRentabilidad(Long id, double nuevaRentabilidad);

    void updateGrasaDesperdicio(Long id, double nuevaGrasaDesperdicio);

    void updateOtrosDesperdicios(Long id, double nuevosOtrosDesperdicios);

    void updateDesperdicio(Long id, Double grasaDesperdicio, Double otrosDesperdicios);

    void eliminarProducto(Long id);
}
