package com.carniceria.gestion_rentabilidad.service;

import java.util.List;

import com.carniceria.gestion_rentabilidad.model.Compra;

public interface CompraService {
    List<Compra> getAllCompras();
    void saveCompra(Compra compra);
}
