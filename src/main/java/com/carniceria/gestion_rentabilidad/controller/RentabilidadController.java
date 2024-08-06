package com.carniceria.gestion_rentabilidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.service.RentabilidadService;

@Controller
public class RentabilidadController {

    private static final Logger logger = LoggerFactory.getLogger(RentabilidadController.class);

    @Autowired
    private RentabilidadService rentabilidadService;

    @GetMapping("/rentabilidad")
    public String verRentabilidad(Model model) {
        logger.info("Obteniendo productos con rentabilidad");
        model.addAttribute("productos", rentabilidadService.obtenerProductosConRentabilidad());
        return "rentabilidad";
    }

    @GetMapping("/rentabilidad/actualizar")
    public String actualizarRentabilidad(@RequestParam Long productoId,
                                          @RequestParam double porcentajeRentabilidad,
                                          @RequestParam int cantidadLote,
                                          Model model) {
        logger.info("Actualizando rentabilidad para producto ID: {} con porcentaje: {} y cantidad de lote: {}", productoId, porcentajeRentabilidad, cantidadLote);

        Producto producto = rentabilidadService.obtenerProductoPorId(productoId);
        if (producto == null) {
            logger.error("Producto no encontrado con ID: {}", productoId);
            return "redirect:/rentabilidad"; // o mostrar un mensaje de error
        }

        double precioCompra = producto.getPrecioCompra();
        double precioVenta = precioCompra * (1 + porcentajeRentabilidad / 100);
        double gananciaEsperada = (precioVenta - precioCompra) * cantidadLote;

        logger.info("Precio Compra: {}, Precio Venta: {}, Ganancia Esperada: {}", precioCompra, precioVenta, gananciaEsperada);

        model.addAttribute("producto", producto);
        model.addAttribute("precioVenta", precioVenta);
        model.addAttribute("gananciaEsperada", gananciaEsperada);
        
        return "rentabilidad";
    }

}
