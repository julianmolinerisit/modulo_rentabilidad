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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.service.ProductoService;
import com.carniceria.gestion_rentabilidad.service.CategoriaService;
import com.carniceria.gestion_rentabilidad.service.CompraService;

@Controller
public class ProductoController {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CompraService compraService;

	@GetMapping("/productos")
	public String mostrarProductos(Model model) {
		List<Producto> productos = productoService.getAllProductos();

		for (Producto producto : productos) {
			double porcentajeRentabilidad = 0;
			if (producto.getInversionTotal() > 0) {
				porcentajeRentabilidad = ((producto.getPrecioVenta() - producto.getInversionTotal() / producto.getStock()) 
						/ (producto.getInversionTotal() / producto.getStock())) * 100;
			}
			producto.setPorcentajeRentabilidad(porcentajeRentabilidad);
			producto.calcularGananciaUnitaria(); // Calcular ganancia unitaria
			producto.calcularGananciaTotal(); // Calcular ganancia total
			producto.calcularDineroTotalRecaudado(); // Calcular dinero total recaudado
		}

		model.addAttribute("productos", productos);
		return "productos";
	}

	@Autowired
    private CategoriaService categoriaService;

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.getAllCategorias()); // Asegúrate de que esta línea sea correcta
        return "crear_producto";
    }

	@PostMapping("/productos")
	public String saveProducto(@ModelAttribute("producto") Producto producto) {
		logger.info("Guardando producto: {}", producto);
		producto.setFechaRegistro(LocalDate.now());
		productoService.saveProducto(producto);
		return "redirect:/productos";
	}

	@PostMapping("/productos/{id}/eliminar")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.eliminarProducto(id);
		return "redirect:/productos";
	}

	@PostMapping("/productos/{id}/importarCompras")
	public String importarCompras(@PathVariable Long id, @RequestParam("compraId") Long compraId) {
	    Producto producto = productoService.getProductoById(id);
	    Compra compra = compraService.getCompraById(compraId);

	    if (producto != null && compra != null) {
	        // Lógica para agregar el stock y actualizar el precio de compra
	        if (compra.getEsPesable()) {
	            producto.setStock(producto.getStock() + (int) compra.getCantidad());
	        } else {
	            producto.setStock(producto.getStock() + (int) compra.getCantidad());
	        }
	        productoService.saveProducto(producto);
	    }

	    return "redirect:/productos";
	}


    @PostMapping("/productos/{id}/actualizarStock")
    public String actualizarStock(@RequestParam("id") Long id, @RequestParam("newStock") int newStock, RedirectAttributes redirectAttributes) {
        productoService.actualizarStock(id, newStock);
        redirectAttributes.addFlashAttribute("message", "Stock actualizado correctamente.");
        return "redirect:/productos";
    }
    
    @PostMapping("/productos/{id}/actualizarPrecioCompra")
    public String actualizarPrecioCompra(@RequestParam("id") Long id, @RequestParam("newStock") Double newPrecioCompra, RedirectAttributes redirectAttributes) {
        productoService.actualizarPrecioCompra(id, newPrecioCompra);
        redirectAttributes.addFlashAttribute("message", "Precio de compra actualizado correctamente.");
        return "redirect:/productos";
    }
    
    
	@GetMapping("/rentabilidad")
	public String mostrarRentabilidad(Model model) {
		List<Producto> productos = productoService.getAllProductos();
		model.addAttribute("productos", productos);
		return "rentabilidad";
	}

	@PostMapping("/productos/{id}/actualizarRentabilidadDatos")
	@ResponseBody
	public void actualizarRentabilidadDatos(@PathVariable("id") Long idProducto,
	        @RequestBody Map<String, Double> datos) {

	    Producto producto = productoService.getProductoById(idProducto);

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
