package com.bolsadeideas.spingboot.backend.apirest.models.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;

public class DemandaPojo {
	
	private Long id_demanda;

	private String nombre_producto;
	private int cantidad_producto;
	private String medida_producto;
	private String departamento_demanda;
	private String ciudad_demanda;
	private String descripcion_demanda;
	private Long consumidor;
	private String estado_demanda;
	private String variedad_producto;
	private String direccion_demanda;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	@PrePersist
	public void prePersist() {
		create_at = new Date();
	}
	
	public DemandaPojo() {
		super();
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
	public void setCantidadproducto(int cantidad_producto) {
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

	public Long getConsumidor() {
		return consumidor;
	}


	public void setConsumidor(Long consumidor) {
		this.consumidor = consumidor;
	}


	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	

}
