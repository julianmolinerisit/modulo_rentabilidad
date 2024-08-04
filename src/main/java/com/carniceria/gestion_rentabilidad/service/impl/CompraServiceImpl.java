package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.repository.CompraRepository;
import com.carniceria.gestion_rentabilidad.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    @Override
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }
}
