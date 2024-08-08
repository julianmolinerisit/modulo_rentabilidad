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
    private Double precioCompra = 0.0;
    private Double precioVenta = 0.0;
    private int stock = 0;
    private double grasaDesperdicio = 0.0;
    private double otrosDesperdicios = 0.0;
    private LocalDate fechaRegistro;
    private Double porcentajeRentabilidad = 0.0;
    private Double gananciaTotal = 0.0;
    private Double gananciaUnitaria = 0.0;
    private Double inversionTotal = 0.0;
    private Double dineroTotalRecaudado = 0.0;
    private Boolean esPesable;

    // Getters y Setters
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

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getGrasaDesperdicio() {
        return grasaDesperdicio;
    }

    public void setGrasaDesperdicio(double grasaDesperdicio) {
        this.grasaDesperdicio = grasaDesperdicio;
    }

    public double getOtrosDesperdicios() {
        return otrosDesperdicios;
    }

    public void setOtrosDesperdicios(double otrosDesperdicios) {
        this.otrosDesperdicios = otrosDesperdicios;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getPorcentajeRentabilidad() {
        return porcentajeRentabilidad;
    }

    public void setPorcentajeRentabilidad(Double porcentajeRentabilidad) {
        this.porcentajeRentabilidad = porcentajeRentabilidad;
    }

    public Double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(Double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }

    public Double getGananciaUnitaria() {
        return gananciaUnitaria;
    }

    public void setGananciaUnitaria(Double gananciaUnitaria) {
        this.gananciaUnitaria = gananciaUnitaria;
    }

    public Double getInversionTotal() {
        return inversionTotal;
    }

    public void setInversionTotal(Double inversionTotal) {
        this.inversionTotal = inversionTotal;
    }

    public Double getDineroTotalRecaudado() {
        return dineroTotalRecaudado;
    }

    public void setDineroTotalRecaudado(Double dineroTotalRecaudado) {
        this.dineroTotalRecaudado = dineroTotalRecaudado;
    }

    public Boolean getEsPesable() {
        return esPesable;
    }

    public void setEsPesable(Boolean esPesable) {
        this.esPesable = esPesable;
    }

    // Método para actualizar la inversión total
    public void actualizarInversionTotal() {
        this.inversionTotal = this.precioCompra * this.stock;
    }

    // Método para calcular la ganancia unitaria
    public void calcularGananciaUnitaria() {
        this.gananciaUnitaria = this.precioVenta - this.precioCompra;
    }

    // Método para calcular la ganancia total
    public void calcularGananciaTotal() {
        this.gananciaTotal = this.gananciaUnitaria * this.stock;
    }

    // Método para calcular el dinero total recaudado
    public void calcularDineroTotalRecaudado() {
        this.dineroTotalRecaudado = this.precioVenta * this.stock;
    }
}
