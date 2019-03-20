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

public class InteresadoPojo {
	
	private Long id_interesado;
	
	private Long consumidor;
	private Long oferta;

	
	
	
	
	
	public InteresadoPojo() {
		super();
	}


	public Long getId_interesado() {
		return id_interesado;
	}


	public void setId_interesado(Long id_interesado) {
		this.id_interesado = id_interesado;
	}


	public Long getConsumidor() {
		return consumidor;
	}


	public void setConsumidor(Long consumidor) {
		this.consumidor = consumidor;
	}


	public Long getOferta() {
		return oferta;
	}


	public void setOferta(Long oferta) {
		this.oferta = oferta;
	}
	
	

}
