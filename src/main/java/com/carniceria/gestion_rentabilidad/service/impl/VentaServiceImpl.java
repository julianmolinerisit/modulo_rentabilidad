package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.gestion_rentabilidad.model.Venta;
import com.carniceria.gestion_rentabilidad.repository.VentaRepository;
import com.carniceria.gestion_rentabilidad.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVentaById(Long id) {
        ventaRepository.deleteById(id);
    }
}
