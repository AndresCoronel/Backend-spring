package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productor")
@NamedQueries({
@NamedQuery(name="Productor.buscarProductorCorreo", query="from Productor where correo_productor=? AND contrasenia_productor=?"),

})
public class Productor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long  cedula_productor;
	
	@Column
	private String nombre_productor;
	private String apellido_productor;
	private Long telefono_productor;
	private String correo_productor;
	private String contrasenia_productor;
	private String sexo_productor;
	
	@OneToMany(mappedBy ="productor")
	private List<Oferta> oferta;
	
	public Long getCedula_productor() {
		return cedula_productor;
	}
	public void setCedula_productor(Long cedula_productor) {
		this.cedula_productor = cedula_productor;
	}
	public String getNombre_productor() {
		return nombre_productor;
	}
	public void setNombre_productor(String nombre_productor) {
		this.nombre_productor = nombre_productor;
	}
	public String getApellido_productor() {
		return apellido_productor;
	}
	public void setApellido_productor(String apellido_productor) {
		this.apellido_productor = apellido_productor;
	}
	public Long getTelefono_productor() {
		return telefono_productor;
	}
	public void setTelefono_productor(Long telefono_productor) {
		this.telefono_productor = telefono_productor;
	}
	public String getCorreo_productor() {
		return correo_productor;
	}
	public void setCorreo_productor(String correo_productor) {
		this.correo_productor = correo_productor;
	}
	public String getContrasenia_productor() {
		return contrasenia_productor;
	}
	public void setContrasenia_productor(String contrasenia_productor) {
		this.contrasenia_productor = contrasenia_productor;
	}
	public String getSexo_productor() {
		return sexo_productor;
	}
	public void setSexo_productor(String sexo_productor) {
		this.sexo_productor = sexo_productor;
	}
	

	
	

}
