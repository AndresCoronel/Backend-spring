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
@Table(name = "testimonio")
public class Testimonio implements Serializable{


	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long id_testimonio;
	
	private String descripcion_testimonio;
	private String nombre_persona;
	private String ciudad_persona;

	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	@PrePersist
	public void prePersist() {
		create_at = new Date();
	}
	
	

	public Long getId_testimonio() {
		return id_testimonio;
	}

	public void setId_testimonio(Long id_testimonio) {
		this.id_testimonio = id_testimonio;
	}

	public String getDescripcion_testimonio() {
		return descripcion_testimonio;
	}

	public void setDescripcion_testimonio(String descripcion_testimonio) {
		this.descripcion_testimonio = descripcion_testimonio;
	}

	

	public String getNombre_persona() {
		return nombre_persona;
	}



	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}



	public String getCiudad_persona() {
		return ciudad_persona;
	}



	public void setCiudad_persona(String ciudad_persona) {
		this.ciudad_persona = ciudad_persona;
	}



	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	
	
}
