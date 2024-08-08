package com.carniceria.gestion_rentabilidad.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carniceria.gestion_rentabilidad.model.Producto;
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
				porcentajeRentabilidad = ((producto.getPrecioVenta() - producto.getPrecioCompra())
						/ producto.getPrecioCompra()) * 100;
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

	@PostMapping("/productos/{id}/eliminar")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.eliminarProducto(id);
		return "redirect:/productos";
	}

	 @GetMapping("/rentabilidad")
	    public String mostrarRentabilidad(Model model) {
	        List<Producto> productos = productoService.obtenerTodosLosProductos();
	        model.addAttribute("productos", productos);
	        return "rentabilidad"; // Asegúrate de que este nombre coincida con tu plantilla HTML
	    }
	

	@PostMapping("/productos/{id}/actualizarRentabilidadDatos")
	@ResponseBody
	public void actualizarRentabilidadDatos(@PathVariable("id") Long idProducto,
	        @RequestBody Map<String, Double> datos) {

	    Producto producto = productoService.obtenerProductoPorId(idProducto);

	    if (producto != null) {
	        double porcentajeRentabilidad = datos.getOrDefault("porcentajeRentabilidad", 0.0);
	        double precioVenta = datos.getOrDefault("precioVenta", 0.0);
	        double gananciaTotal = datos.getOrDefault("gananciaTotal", 0.0);
	        double gananciaUnitaria = datos.getOrDefault("gananciaUnitaria", 0.0);
	        double inversionTotal = datos.getOrDefault("inversionTotal", 0.0);
	        double dineroTotalRecaudado = datos.getOrDefault("dineroTotalRecaudado", 0.0);
	        double grasaDesperdicio = datos.getOrDefault("grasaDesperdicio", 0.0);
	        double otrosDesperdicios = datos.getOrDefault("otrosDesperdicios", 0.0);

	        producto.setPorcentajeRentabilidad(porcentajeRentabilidad);
	        producto.setPrecioVenta(precioVenta);
	        producto.setGananciaTotal(gananciaTotal);
	        producto.setGananciaUnitaria(gananciaUnitaria);
	        producto.setInversionTotal(inversionTotal);
	        producto.setDineroTotalRecaudado(dineroTotalRecaudado);
	        producto.setGrasaDesperdicio(grasaDesperdicio);
	        producto.setOtrosDesperdicios(otrosDesperdicios);

	        productoService.saveProducto(producto);
	    }
	}


}