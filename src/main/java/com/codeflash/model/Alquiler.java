package com.codeflash.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;


@Entity
public class Alquiler {
	 @Id
	private String idalquiler;
	 

	private Cliente cliente;
	 
	 public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	private Vehiculo vehiculo;
	 
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private BigDecimal precio;
	public String getIdalquiler() {
		return idalquiler;
	}
	public void setIdalquiler(String idalquiler) {
		this.idalquiler = idalquiler;
	}
	

	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	} 

}
