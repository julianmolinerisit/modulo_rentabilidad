package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Producto;

public interface ProductoService {

    List<Producto> getAllProductos();

    Producto getProductoById(Long id);

    void saveProducto(Producto producto);

    void updateStock(Long id, int newStock);

    void updateDesperdicio(Long id, Double grasaDesperdicio, Double otrosDesperdicios);

	void eliminarProducto(Long id);
}
