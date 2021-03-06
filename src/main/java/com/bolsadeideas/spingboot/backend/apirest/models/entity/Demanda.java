package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="demanda")
public class Demanda implements Serializable {
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long id_demanda;
	
	@Column
	private String nombre_producto;
	private int cantidad_producto;
	private String medida_producto;
	private String descripcion_demanda;
	private String estado_demanda;
	private String variedad_producto;
	private String direccion_demanda;
	
	
	@ManyToOne
	@JoinColumn(name="cedula_consumidor")
	private Consumidor consumidor;

	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	@PrePersist
	public void prePersist() {
		create_at = new Date();
	}

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

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public String getEstado_demanda() {
		return estado_demanda;
	}

	public void setEstado_demanda(String estado_demanda) {
		this.estado_demanda = estado_demanda;
	}

	public String getVariedad_producto() {
		return variedad_producto;
	}

	public void setVariedad_producto(String variedad_producto) {
		this.variedad_producto = variedad_producto;
	}

	public String getDireccion_demanda() {
		return direccion_demanda;
	}

	public void setDireccion_demanda(String direccion_demanda) {
		this.direccion_demanda = direccion_demanda;
	}

	public String getMedida_producto() {
		return medida_producto;
	}



	public void setMedida_producto(String medida_producto) {
		this.medida_producto = medida_producto;
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	



	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
