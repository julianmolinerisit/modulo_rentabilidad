package com.carniceria.gestion_rentabilidad.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private boolean esPesable;
    private Double grasaDesperdicio;
    private Double otrosDesperdicios;
    private LocalDate fechaRegistro;
    private double porcentajeRentabilidad = 0.0;
    private double inversionTotal = 0.0; // Nuevo atributo para inversión total

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEsPesable() {
        return esPesable;
    }

    public void setEsPesable(boolean esPesable) {
        this.esPesable = esPesable;
    }

    public Double getGrasaDesperdicio() {
        return grasaDesperdicio;
    }

    public void setGrasaDesperdicio(Double grasaDesperdicio) {
        this.grasaDesperdicio = grasaDesperdicio;
    }

    public Double getOtrosDesperdicios() {
        return otrosDesperdicios;
    }

    public void setOtrosDesperdicios(Double otrosDesperdicios) {
        this.otrosDesperdicios = otrosDesperdicios;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getPorcentajeRentabilidad() {
        return porcentajeRentabilidad;
    }

    public void setPorcentajeRentabilidad(double porcentajeRentabilidad) {
        this.porcentajeRentabilidad = porcentajeRentabilidad;
    }

    public double getInversionTotal() {
        return inversionTotal;
    }

    public void setInversionTotal(double inversionTotal) {
        this.inversionTotal = inversionTotal;
    }

    

    public void actualizarInversionTotal() {
        this.inversionTotal = this.precioCompra * this.stock;
    }

    // Método para obtener la representación del stock
    public String getStockRepresentation() {
        return esPesable ? stock + " kg" : stock + " unidades";
    }
}
