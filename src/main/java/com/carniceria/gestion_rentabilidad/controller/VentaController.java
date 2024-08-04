package com.carniceria.gestion_rentabilidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carniceria.gestion_rentabilidad.model.Venta;
import com.carniceria.gestion_rentabilidad.service.ProductoService;
import com.carniceria.gestion_rentabilidad.service.VentaService;

@Controller
public class VentaController {

    private static final Logger logger = LoggerFactory.getLogger(VentaController.class);

    @Autowired
    private VentaService ventaService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/ventas")
    public String listVentas(Model model) {
        logger.info("Listando todas las ventas");
        model.addAttribute("ventas", ventaService.getAllVentas());
        return "ventas";
    }
    
    @GetMapping("/ventas/nueva")
    public String createVentaForm(Model model) {
        logger.info("Creando formulario para nueva venta");
        model.addAttribute("venta", new Venta());
        model.addAttribute("productos", productoService.getAllProductos());
        return "crear_venta";
    }
    
    @PostMapping("/ventas")
    public String saveVenta(@ModelAttribute("venta") Venta venta) {
        logger.info("Guardando nueva venta: {}", venta);
        ventaService.saveVenta(venta);
        return "redirect:/ventas";
    }
}
