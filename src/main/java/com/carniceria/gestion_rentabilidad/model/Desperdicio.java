package com.carniceria.gestion_rentabilidad.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Desperdicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productoId;
	private Double grasaDesperdicio;
	private Double otrosDesperdicios;
	private LocalDate fecha; // Fecha del registro

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	// Getters y setters
}
