package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="demanda")
public class Demanda implements Serializable {
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long id_demanda;
	
	@Column
	private String nombre_producto;
	private Long cantidad_producto;
	private String medida_producto;
	private String departamento_demanda;
	private String ciudad_demanda;
	private String descripcion_demanda;
	
	
	@ManyToOne
	@JoinColumn(name="cedula_consumidor")
	private Consumidor consumidor;



	public Long getId_demanda() {
		return id_demanda;
	}



	public void setId_demanda(Long id_demanda) {
		this.id_demanda = id_demanda;
	}



	public String getNombre_producto() {
		return nombre_producto;
	}



	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}



	public Long getCantidad_producto() {
		return cantidad_producto;
	}



	public void setCantidad_producto(Long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}



	public String getMedida_producto() {
		return medida_producto;
	}



	public void setMedida_producto(String medida_producto) {
		this.medida_producto = medida_producto;
	}



	public String getDepartamento_demanda() {
		return departamento_demanda;
	}



	public void setDepartamento_demanda(String departamento_demanda) {
		this.departamento_demanda = departamento_demanda;
	}



	public String getCiudad_demanda() {
		return ciudad_demanda;
	}



	public void setCiudad_demanda(String ciudad_demanda) {
		this.ciudad_demanda = ciudad_demanda;
	}



	public String getDescripcion_demanda() {
		return descripcion_demanda;
	}



	public void setDescripcion_demanda(String descripcion_demanda) {
		this.descripcion_demanda = descripcion_demanda;
	}



	public Consumidor getConsumidor() {
		return consumidor;
	}



	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
