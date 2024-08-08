package com.carniceria.gestion_rentabilidad.controller;

import com.carniceria.gestion_rentabilidad.model.Compra;
import com.carniceria.gestion_rentabilidad.model.Producto;
import com.carniceria.gestion_rentabilidad.model.Proveedor;
import com.carniceria.gestion_rentabilidad.service.CompraService;
import com.carniceria.gestion_rentabilidad.service.ProductoService;
import com.carniceria.gestion_rentabilidad.service.ProveedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraController {

    private static final Logger logger = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;

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
        model.addAttribute("proveedores", proveedorService.getAllProveedores());
        return "crear_compra";
    }

    @PostMapping("/compras")
    public String saveCompra(@ModelAttribute("compra") Compra compra) {
        logger.info("Guardando nueva compra: {}", compra);

        Proveedor proveedor = proveedorService.getProveedorById(compra.getProveedor().getId());

        if (proveedor != null) {
            if (!compra.isPagado()) {
                proveedor.setDeuda(proveedor.getDeuda() + compra.getTotal());
                proveedorService.saveProveedor(proveedor);
            }
        } else {
            logger.error("Proveedor no encontrado: {}", compra.getProveedor().getId());
        }

        // Actualizar el stock del producto
        Producto producto = productoService.getProductoById(compra.getProducto().getId());
        if (producto != null) {
            if (compra.getEsPesable()) {
                producto.setStock(producto.getStock() + (int) compra.getCantidad()); // Suma la cantidad en kilos
            } else {
                producto.setStock(producto.getStock() + (int) compra.getCantidad()); // Suma la cantidad en unidades
            }
            productoService.saveProducto(producto);
        } else {
            logger.error("Producto no encontrado: {}", compra.getProducto().getId());
        }

        compraService.saveCompra(compra);
        return "redirect:/compras";
    }
}
