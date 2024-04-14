package com.codeflash.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String idvehiculo;
	 
	private String marca;
	private String modelo;
	private String matricula;
	private int capacidad;
	private int color;
	
	public boolean esNuevoVehiculo() {
		return idvehiculo == null;
	}
	
	public String getIdvehiculo() {
		return idvehiculo;
	}
	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Vehiculo [idvehiculo=" + idvehiculo + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
				+ matricula + ", capacidad=" + capacidad + ", color=" + color + "]";
	}


}
