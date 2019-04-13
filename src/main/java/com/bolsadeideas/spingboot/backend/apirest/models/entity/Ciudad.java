package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")

public class Ciudad implements Serializable {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private int id_ciudad;

	@Column
	private String nombre_ciudad;
	private double lat_ciudad;
	private double long_ciudad;
	private String departamento_ciudad;

	
	
	
	@OneToMany(mappedBy ="ciudad")
	private List<Demanda> demanda;
	
	@OneToMany(mappedBy ="ciudad")
	private List<Oferta> oferta;


	public int getId_ciudad() {
		return id_ciudad;
	}


	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}


	public String getNombre_ciudad() {
		return nombre_ciudad;
	}


	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}


	public double getLat_ciudad() {
		return lat_ciudad;
	}


	public void setLat_ciudad(double lat_ciudad) {
		this.lat_ciudad = lat_ciudad;
	}


	public double getLong_ciudad() {
		return long_ciudad;
	}


	public void setLong_ciudad(double long_ciudad) {
		this.long_ciudad = long_ciudad;
	}


	public String getDepartamento_ciudad() {
		return departamento_ciudad;
	}


	public void setDepartamento_ciudad(String departamento_ciudad) {
		this.departamento_ciudad = departamento_ciudad;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
