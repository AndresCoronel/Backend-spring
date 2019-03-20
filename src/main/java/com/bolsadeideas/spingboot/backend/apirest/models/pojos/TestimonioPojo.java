package com.bolsadeideas.spingboot.backend.apirest.models.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TestimonioPojo {

	private Long id_testimonio;
	private String descripcion_testimonio;
	private Long productor;
	private Long consumidor;
	
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

	public Long getProductor() {
		return productor;
	}

	public void setProductor(Long productor) {
		this.productor = productor;
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
