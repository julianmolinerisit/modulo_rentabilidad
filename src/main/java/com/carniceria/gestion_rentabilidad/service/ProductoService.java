package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Producto;

public interface ProductoService {

    List<Producto> getAllProductos();

    Producto getProductoById(Long id);

    void saveProducto(Producto producto);

    void eliminarProducto(Long id);

    Producto obtenerProductoPorId(Long id);

    void actualizarProducto(Producto producto); // Método para actualizar el producto completo

    void deleteProductoById(Long id); // Método que también elimina un producto por ID

	List<Producto> obtenerTodosLosProductos();
}
