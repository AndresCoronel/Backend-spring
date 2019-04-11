package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consumidor")
public class Consumidor implements Serializable {

	@Id
	private Long cedula_consumidor;

	@Column
	private String nombre_consumidor;
	private String apellido_consumidor;
	private Long telefono_consumidor;
	private String correo_consumidor;
	private String contrasenia_consumidor;
	private String sexo_consumidor;
	
	
	@OneToMany(mappedBy ="consumidor")
	private List<Demanda> demanda;

	public Long getCedula_consumidor() {
		return cedula_consumidor;
	}

	public void setCedula_consumidor(Long cedula_consumidor) {
		this.cedula_consumidor = cedula_consumidor;
	}

	public String getNombre_consumidor() {
		return nombre_consumidor;
	}

	public void setNombre_consumidor(String nombre_consumidor) {
		this.nombre_consumidor = nombre_consumidor;
	}

	public String getApellido_consumidor() {
		return apellido_consumidor;
	}

	public void setApellido_consumidor(String apellido_consumidor) {
		this.apellido_consumidor = apellido_consumidor;
	}

	public Long getTelefono_consumidor() {
		return telefono_consumidor;
	}

	public void setTelefono_consumidor(Long telefono_consumidor) {
		this.telefono_consumidor = telefono_consumidor;
	}

	public String getCorreo_consumidor() {
		return correo_consumidor;
	}

	public void setCorreo_consumidor(String correo_consumidor) {
		this.correo_consumidor = correo_consumidor;
	}

	public String getContrasenia_consumidor() {
		return contrasenia_consumidor;
	}

	public void setContrasenia_consumidor(String contrasenia_consumidor) {
		this.contrasenia_consumidor = contrasenia_consumidor;
	}

	
	public String getSexo_consumidor() {
		return sexo_consumidor;
	}

	public void setSexo_consumidor(String sexo_consumidor) {
		this.sexo_consumidor = sexo_consumidor;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
