package com.carniceria.gestion_rentabilidad.controller;

public class ProductoDto {
    private double precioVenta;
    private double porcentajeRentabilidad;
    private double grasaDesperdicio;
    private double otrosDesperdicios;
    private Double inversionTotal;

    // Getters y setters
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPorcentajeRentabilidad() {
        return porcentajeRentabilidad;
    }

    public void setPorcentajeRentabilidad(double porcentajeRentabilidad) {
        this.porcentajeRentabilidad = porcentajeRentabilidad;
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

	public Double getInversionTotal() {
		return inversionTotal;
	}

	public void setInversionTotal(Double inversionTotal) {
		this.inversionTotal = inversionTotal;
	}
}
