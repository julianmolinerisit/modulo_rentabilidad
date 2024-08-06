package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Producto;

public interface RentabilidadService {

    List<Producto> obtenerProductosConRentabilidad();
    
    Producto obtenerProductoPorId(Long id);

	void actualizarProducto(Producto producto);
}
