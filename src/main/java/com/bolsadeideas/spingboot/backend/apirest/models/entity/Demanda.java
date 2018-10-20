package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String ubicacion_producto;
	
	@ManyToOne
	@JoinColumn(name="cedula_consumidor")
	private Consumidor consumidor;

	public Long getIdDemanda() {
		return id_demanda;
	}
	public void setIdDemanda(Long id_demanda) {
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
	public String getUbicacion_producto() {
		return ubicacion_producto;
	}
	public void setUbicacion_producto(String ubicacion_producto) {
		this.ubicacion_producto = ubicacion_producto;
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
