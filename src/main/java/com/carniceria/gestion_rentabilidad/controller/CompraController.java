package com.carniceria.gestion_rentabilidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.service.CompraService;
import com.carniceria.gestion_rentabilidad.service.ProductoService;

@Controller
public class CompraController {

    private static final Logger logger = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/compras")
    public String listCompras(Model model) {
        logger.info("Listando todas las compras");
        model.addAttribute("compras", compraService.getAllCompras());
        return "compras";
    }
    
    @GetMapping("/compras/nueva")
    public String createCompraForm(Model model) {
        logger.info("Creando formulario para nueva compra");
        model.addAttribute("compra", new Compra());
        model.addAttribute("productos", productoService.getAllProductos());
        return "crear_compra";
    }
    
    @PostMapping("/compras")
    public String saveCompra(@ModelAttribute("compra") Compra compra) {
        logger.info("Guardando nueva compra: {}", compra);
        compraService.saveCompra(compra);
        return "redirect:/compras";
    }
}
