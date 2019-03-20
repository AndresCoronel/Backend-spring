package com.bolsadeideas.spingboot.backend.apirest.models.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class OfertaPojo {
	
	private Long id_oferta;
	private String nombre_producto;
	private String unidad_medida_producto;
	private int cantidad_producto;
	private int precio_producto;
	private String variedad_producto;
	private String descripcion_producto;
	private Double latitud_oferta;
	private Double longitud_oferta;
	private String lugar_oferta;
	private String estado_oferta;
	private Long productor;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	@PrePersist
	public void prePersist() {
		create_at = new Date();
	}

	public OfertaPojo() {
		super();
	}

	public Long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Long id_oferta) {
		this.id_oferta = id_oferta;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getUnidad_medida_producto() {
		return unidad_medida_producto;
	}

	public void setUnidad_medida_producto(String unidad_medida_producto) {
		this.unidad_medida_producto = unidad_medida_producto;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getVariedad_producto() {
		return variedad_producto;
	}

	public void setVariedad_producto(String variedad_producto) {
		this.variedad_producto = variedad_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Double getLatitud_oferta() {
		return latitud_oferta;
	}

	public void setLatitud_oferta(Double latitud_oferta) {
		this.latitud_oferta = latitud_oferta;
	}

	public Double getLongitud_oferta() {
		return longitud_oferta;
	}

	public void setLongitud_oferta(Double longitud_oferta) {
		this.longitud_oferta = longitud_oferta;
	}

	public String getLugar_oferta() {
		return lugar_oferta;
	}

	public void setLugar_oferta(String lugar_oferta) {
		this.lugar_oferta = lugar_oferta;
	}

	public String getEstado_oferta() {
		return estado_oferta;
	}

	public void setEstado_oferta(String estado_oferta) {
		this.estado_oferta = estado_oferta;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Long getProductor() {
		return productor;
	}

	public void setProductor(Long productor) {
		this.productor = productor;
	}
	
	
	
	
	
	
}
