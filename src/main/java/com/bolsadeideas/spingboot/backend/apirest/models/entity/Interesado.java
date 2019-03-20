package com.bolsadeideas.spingboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "interesado")
public class Interesado implements Serializable {

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private Long id_interesado;

	
	@ManyToOne
	@JoinColumn(name="id_oferta")
	private Oferta oferta;
	
	@ManyToOne
	@JoinColumn(name="cedula_consumidor")
	private Consumidor consumidor;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getId_interesado() {
		return id_interesado;
	}

	public void setId_interesado(Long id_interesado) {
		this.id_interesado = id_interesado;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	
}
