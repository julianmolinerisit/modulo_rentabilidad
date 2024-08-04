package com.carniceria.gestion_rentabilidad.service;

import java.util.List;
import com.carniceria.gestion_rentabilidad.model.Desperdicio;

public interface DesperdicioService {
    List<Desperdicio> getAllDesperdicios();
    void saveDesperdicio(Desperdicio desperdicio);
}
