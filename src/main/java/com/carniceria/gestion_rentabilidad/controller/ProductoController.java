package com.carniceria.gestion_rentabilidad.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.controller.ProductoDto;
import com.carniceria.gestion_rentabilidad.service.ProductoService;
import com.carniceria.gestion_rentabilidad.service.RentabilidadService;

@Controller
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private RentabilidadService rentabilidadService;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        
        for (Producto producto : productos) {
            double porcentajeRentabilidad = 0;
            if (producto.getPrecioCompra() > 0) {
                porcentajeRentabilidad = ((producto.getPrecioVenta() - producto.getPrecioCompra()) / producto.getPrecioCompra()) * 100;
            }
            producto.setPorcentajeRentabilidad(porcentajeRentabilidad);
            producto.actualizarInversionTotal(); // Actualizar inversión total
        }

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
        producto.setFechaRegistro(LocalDate.now());
        producto.actualizarInversionTotal(); // Actualizar inversión total
        productoService.saveProducto(producto);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/actualizarStock")
    public String updateStock(@PathVariable Long id, @RequestParam int newStock) {
        logger.info("Actualizando stock para producto ID: {} con nuevo stock: {}", id, newStock);
        productoService.updateStock(id, newStock);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/actualizarPrecioVenta")
    public String updatePrecioVenta(@PathVariable Long id, @RequestParam double nuevoPrecioVenta) {
        logger.info("Actualizando precio de venta para producto ID: {} con nuevo precio: {}", id, nuevoPrecioVenta);
        productoService.updatePrecioVenta(id, nuevoPrecioVenta);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/actualizarRentabilidad")
    public String updateRentabilidad(@PathVariable Long id, @RequestParam double nuevaRentabilidad) {
        logger.info("Actualizando rentabilidad para producto ID: {} con nueva rentabilidad: {}", id, nuevaRentabilidad);
        productoService.updateRentabilidad(id, nuevaRentabilidad);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/actualizarGrasaDesperdicio")
    public String updateGrasaDesperdicio(@PathVariable Long id, @RequestParam double nuevaGrasaDesperdicio) {
        logger.info("Actualizando grasa de desperdicio para producto ID: {} con nueva grasa: {}", id, nuevaGrasaDesperdicio);
        productoService.updateGrasaDesperdicio(id, nuevaGrasaDesperdicio);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/actualizarOtrosDesperdicios")
    public String updateOtrosDesperdicios(@PathVariable Long id, @RequestParam double nuevosOtrosDesperdicios) {
        logger.info("Actualizando otros desperdicios para producto ID: {} con nuevos desperdicios: {}", id, nuevosOtrosDesperdicios);
        productoService.updateOtrosDesperdicios(id, nuevosOtrosDesperdicios);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/rentabilidad")
    public String verRentabilidad(Model model) {
        logger.info("Obteniendo productos con rentabilidad");
        List<Producto> productosConRentabilidad = rentabilidadService.obtenerProductosConRentabilidad();
        if (productosConRentabilidad != null) {
            logger.info("Número de productos obtenidos: {}", productosConRentabilidad.size());
        } else {
            logger.warn("La lista de productos con rentabilidad es nula");
        }
        model.addAttribute("productos", productosConRentabilidad);
        return "rentabilidad";
    }

}
