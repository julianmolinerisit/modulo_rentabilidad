package com.carniceria.gestion_rentabilidad.service;

import java.util.List;
import com.carniceria.gestion_rentabilidad.model.Categoria;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Categoria getCategoriaById(Long id);
    Categoria saveCategoria(Categoria categoria);
    void deleteCategoria(Long id);
}
