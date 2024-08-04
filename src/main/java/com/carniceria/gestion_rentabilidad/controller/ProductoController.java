package com.carniceria.gestion_rentabilidad.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carniceria.gestion_rentabilidad.model.Desperdicio;
import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.service.DesperdicioService;
import com.carniceria.gestion_rentabilidad.service.ProductoService;

@Controller
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private DesperdicioService desperdicioService;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        logger.info("Obteniendo todos los productos: {}", productos);
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String createProductoForm(Model model) {
        logger.info("Creando nuevo formulario de producto");
        model.addAttribute("producto", new Producto());
        return "crear_producto";
    }
    
    @PostMapping("/productos")
    public String saveProducto(@ModelAttribute("producto") Producto producto) {
        logger.info("Guardando producto: {}", producto);
        productoService.saveProducto(producto);
        return "redirect:/productos";
    }
    
    @PostMapping("/productos/{id}/actualizarStock")
    public String updateStock(@PathVariable Long id, @RequestParam int newStock) {
        logger.info("Actualizando stock para producto ID: {} con nuevo stock: {}", id, newStock);
        productoService.updateStock(id, newStock);
        return "redirect:/productos";
    }
    
    @PostMapping("/productos/{id}/actualizarDesperdicio")
    public String updateDesperdicio(@PathVariable Long id,
                                    @RequestParam Double grasaDesperdicio,
                                    @RequestParam Double otrosDesperdicios) {
        logger.info("Actualizando desperdicio para producto ID: {} con grasa: {} y otros: {}", id, grasaDesperdicio, otrosDesperdicios);
        Desperdicio desperdicio = new Desperdicio();
        desperdicio.setProductoId(id);
        desperdicio.setGrasaDesperdicio(grasaDesperdicio);
        desperdicio.setOtrosDesperdicios(otrosDesperdicios);
        desperdicio.setFecha(LocalDate.now());
        desperdicioService.saveDesperdicio(desperdicio);
        return "redirect:/productos";
    }
}
