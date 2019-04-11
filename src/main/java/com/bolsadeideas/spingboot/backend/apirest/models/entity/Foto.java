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
@Table(name = "foto")
public class Foto implements Serializable{
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long id_foto;
	
	@Column
	private String url_foto;
	
	@ManyToOne
	@JoinColumn(name="id_oferta")
	private Oferta oferta;

	public Long getId_foto() {
		return id_foto;
	}

	public void setId_foto(Long id_foto) {
		this.id_foto = id_foto;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	
	
}
