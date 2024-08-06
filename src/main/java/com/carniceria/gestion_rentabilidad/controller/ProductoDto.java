package com.carniceria.gestion_rentabilidad.controller;

public class ProductoDto {
    private double precioVenta;
    private double gananciaEsperada;
    private double grasaDesperdicio;
    private double otrosDesperdicios;

    // Getters y setters
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getGananciaEsperada() {
        return gananciaEsperada;
    }

    public void setGananciaEsperada(double gananciaEsperada) {
        this.gananciaEsperada = gananciaEsperada;
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
}
