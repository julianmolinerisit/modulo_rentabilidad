package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Venta;

public interface VentaService {
    List<Venta> getAllVentas();
    void saveVenta(Venta venta);
}
