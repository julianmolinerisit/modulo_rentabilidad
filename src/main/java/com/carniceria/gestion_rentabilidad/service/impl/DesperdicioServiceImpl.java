package com.carniceria.gestion_rentabilidad.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carniceria.gestion_rentabilidad.model.Desperdicio;
import com.carniceria.gestion_rentabilidad.repository.DesperdicioRepository;
import com.carniceria.gestion_rentabilidad.service.DesperdicioService;

@Service
public class DesperdicioServiceImpl implements DesperdicioService {
    @Autowired
    private DesperdicioRepository desperdicioRepository;

    @Override
    public List<Desperdicio> getAllDesperdicios() {
        return desperdicioRepository.findAll();
    }

    @Override
    public void saveDesperdicio(Desperdicio desperdicio) {
        desperdicioRepository.save(desperdicio);
    }
}
